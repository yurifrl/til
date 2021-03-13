{-#LANGUAGE DeriveDataTypeable #-}
{-#LANGUAGE FlexibleInstances #-}
{-#LANGUAGE MultiParamTypeClasses #-}
{-#LANGUAGE RankNTypes #-}
-------------------------------------------------------------------------------
-- |
-- Module      :  Control.Monad.Telnyx
-- Copyright   :  (C) 2017- Mark Andrus Roberts
-- License     :  BSD-style (see the file LICENSE)
-- Maintainer  :  Mark Andrus Roberts <markandrusroberts@gmail.com>
-- Stability   :  provisional
-------------------------------------------------------------------------------
module Control.Monad.Telnyx
  ( -- * The Telnyx monad
    Telnyx
  , runTelnyx
  , runTelnyx'
    -- * The Telnyx monad transformer
  , TelnyxT(..)
  , runTelnyxT
  , runTelnyxT'
    -- * Types
  , Credentials
  , TelnyxException(..)
  ) where

import Control.Exception
import Control.Monad
import Control.Monad.Catch
import Control.Monad.IO.Class
import Control.Monad.Reader.Class
import Control.Monad.Trans.Class
import Control.Monad.Trans.Free
import qualified Data.ByteString.Lazy as LBS
import Data.Text (Text)
import qualified Data.Text as T
import Data.Typeable
import Network.HTTP.Client

import Telnyx.Internal.Request
import Telnyx.Types.AuthToken
import Telnyx.Types.SIDs

{- The Telnyx monad -}

-- | This monad allows you to make authenticated REST API requests to Telnyx
-- using your 'AccountSID' and 'AuthToken'.
type Telnyx = TelnyxT IO

-- | Run zero or more REST API requests to Telnyx.
runTelnyx :: Credentials -> Telnyx a -> IO a
runTelnyx = runTelnyxT

{- | Parse an 'AccountSID' and 'AuthToken' before running zero or more REST API
requests to Telnyx.

For example, you can fetch the 'Calls' resource in the 'IO' monad as follows:

>module Main where
>
>import Control.Monad.IO.Class (liftIO)
>import System.Environment (getEnv)
>import Telnyx.Calls as Calls
>import Telnyx.Types
>
>-- | Print calls.
>main :: IO ()
>main = runTelnyx' (getEnv "ACCOUNT_SID")
>                  (getEnv "AUTH_TOKEN")
>     $ Calls.get >>= liftIO . print
-}
runTelnyx' :: IO String  -- ^ Account SID
           -> IO String  -- ^ Authentication Token
           -> Telnyx a
           -> IO a
runTelnyx' = runTelnyxT'

{- The Telnyx monad transformer -}

-- | This monad transformer allows you to make authenticated REST API requests
-- to Telnyx using your 'AccountSID' and 'AuthToken'.
newtype TelnyxT m a = TelnyxT (Monad m => (Credentials, AccountSID) -> RequestT m a)

getTelnyxT :: Monad m => TelnyxT m a -> (Credentials, AccountSID) -> RequestT m a
getTelnyxT (TelnyxT f) = f

instance Monad m => MonadRequest (TelnyxT m) where
  request go r
    = TelnyxT $ \config -> RequestT . FreeT . return . Free
    $ RequestF (r, \response -> runRequestT $ getTelnyxT (go response) config)

-- | Run zero or more REST API requests to Telnyx, unwrapping the inner monad
-- @m@.
runTelnyxT :: MonadIO m => Credentials -> TelnyxT m a -> m a
runTelnyxT credentials@(accountSID, authToken) (TelnyxT go) = do
  let basicAuthCredentials = (getSID accountSID, getAuthToken authToken)
  let requestM = go (credentials, accountSID)
  runRequest' basicAuthCredentials requestM

-- | Parse an 'AccountSID' and 'AuthToken' before running zero or more REST API
-- requests to Telnyx, unwrapping the inner monad @m@.
runTelnyxT' :: (MonadThrow m, MonadIO m)
            => m String     -- ^ Account SID
            -> m String     -- ^ Authentication Token
            -> TelnyxT m a
            -> m a
runTelnyxT' getAccountSID getAuthToken Telnyx = do
  accountSID <- T.pack <$> getAccountSID
  authToken  <- T.pack <$> getAuthToken
  case parseCredentials accountSID authToken of
    Nothing -> throwM InvalidCredentials
    Just credentials -> runTelnyxT credentials Telnyx

instance Functor (TelnyxT m) where
  fmap f ma = TelnyxT $ \credentials -> do
    a <- getTelnyxT ma credentials
    return $ f a

liftTelnyxT :: m a -> TelnyxT m a
liftTelnyxT m = TelnyxT (const (lift m))

instance Applicative m => Applicative (TelnyxT m) where
  pure = liftTelnyxT . pure
  f <*> v = TelnyxT $ \r -> getTelnyxT f r <*> getTelnyxT v r

{-
instance Alternative m => Alternative (TelnyxT m) where
  empty = liftTelnyxT empty
  m <|> n = TelnyxT $ \r -> getTelnyxT m r <|> getTelnyxT n r
-}

instance Monad m => Monad (TelnyxT m) where
  return a = TelnyxT (return . const a)
  m >>= k = TelnyxT $ \client -> do
    a <- getTelnyxT m client
    getTelnyxT (k a) client

instance Monad m => MonadReader (Credentials, AccountSID) (TelnyxT m) where
  ask = TelnyxT return
  local f m = TelnyxT $ getTelnyxT m . f

instance MonadThrow m => MonadThrow (TelnyxT m) where
  throwM = liftTelnyxT . throwM

instance MonadTrans TelnyxT where
  lift m = TelnyxT $ const (lift m)

instance MonadIO m => MonadIO (TelnyxT m) where
  liftIO = lift . liftIO

{- Types -}

-- | Your 'AccountSID' and 'AuthToken' are used to make authenticated REST API
-- requests to Telnyx.
type Credentials = (AccountSID, AuthToken)

parseCredentials
  :: Text               -- ^ Account SID
  -> Text               -- ^ Authentication Token
  -> Maybe Credentials
parseCredentials accountSID authToken = uncurry (liftM2 (,))
  ( parseSID accountSID :: Maybe AccountSID
  , parseAuthToken authToken )

-- | The set of 'Exception's that may be thrown when attempting to make
-- requests against Telnyx's REST API.
data TelnyxException
  = InvalidSID         !Text
  | InvalidAuthToken   !Text
  | InvalidCredentials
  | UnexpectedResponse !(Response LBS.ByteString)
  deriving (Show, Eq, Typeable)

instance Exception TelnyxException