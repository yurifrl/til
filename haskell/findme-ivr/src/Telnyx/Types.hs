{-#LANGUAGE CPP #-}
{-#LANGUAGE FlexibleInstances #-}
{-#LANGUAGE FlexibleContexts #-}
{-#LANGUAGE LambdaCase #-}
{-#LANGUAGE MultiParamTypeClasses #-}
{-#LANGUAGE OverloadedStrings #-}
{-#LANGUAGE Rank2Types #-}
{-#LANGUAGE ScopedTypeVariables #-}
-------------------------------------------------------------------------------
-- |
-- Module      :  Telnyx.Types
-- Copyright   :  (C) 2017- Mark Andrus Roberts
-- License     :  BSD-style (see the file LICENSE)
-- Maintainer  :  Mark Andrus Roberts <markandrusroberts@gmail.com>
-- Stability   :  provisional
-------------------------------------------------------------------------------
module Telnyx.Types
  ( APIVersion(..)
  , module X
    -- * Misc
  , makeTelnyxRequest
  , makeTelnyxRequest'
  , makeTelnyxPOSTRequest
  , makeTelnyxPOSTRequest'
  , makeTelnyxDELETERequest
  , makeTelnyxDELETERequest'
  ) where

import Control.Exception
import Control.Monad
import Control.Monad.Reader.Class
import Data.Aeson
import qualified Data.ByteString.Char8 as C
import Data.Monoid
import Data.Text (Text)
import qualified Data.Text as T
import Network.HTTP.Client
import Network.HTTP.Types
import Control.Monad.Telnyx
import Telnyx.Internal.Parser
import Telnyx.Internal.Request

data APIVersion
  = API_2010_04_01
  | API_2008_08_01
  deriving Eq

instance Read APIVersion where
  readsPrec _ = \case
    "2010-04-01" -> return (API_2010_04_01, "")
    "2008-08-01" -> return (API_2008_08_01, "")
    _            -> mzero

instance Show APIVersion where
  show API_2010_04_01 = "2010-04-01"
  show API_2008_08_01 = "2008-08-01"

instance FromJSON APIVersion where
  parseJSON (String "2010-04-01") = return API_2010_04_01
  parseJSON (String "2008-08-01") = return API_2008_08_01
  parseJSON _ = mzero

makeTelnyxRequest' :: Monad m => Text -> TelnyxT m Request
makeTelnyxRequest' suffix = do
  ((accountSID, authToken), _) <- ask
  let Just request = parseUrl . T.unpack $ baseURL <> suffix
  return $ applyBasicAuth (C.pack . T.unpack $ getSID accountSID)
                          (C.pack . T.unpack $ getAuthToken authToken) request

makeTelnyxRequest :: Monad m => Text -> TelnyxT m Request
makeTelnyxRequest suffix = do
  ((_, _), accountSID) <- ask
  makeTelnyxRequest' $ "/Accounts/" <> getSID accountSID <> suffix

makeTelnyxPOSTRequest' :: Monad m
                       => Text
                       -> [(C.ByteString, C.ByteString)]
                       -> TelnyxT m Request
makeTelnyxPOSTRequest' resourceURL params =
  makeTelnyxRequest' resourceURL <&> urlEncodedBody params

makeTelnyxPOSTRequest :: Monad m
                      => Text
                      -> [(C.ByteString, C.ByteString)]
                      -> TelnyxT m Request
makeTelnyxPOSTRequest resourceURL params =
  makeTelnyxRequest resourceURL <&> urlEncodedBody params

makeTelnyxDELETERequest' :: Monad m
                         => Text
                         -> TelnyxT m Request
makeTelnyxDELETERequest' resourceURL =
  makeTelnyxRequest' resourceURL <&> (\req -> req {
    method = "DELETE",
    checkStatus = throwForNon204
  })

makeTelnyxDELETERequest :: Monad m
                        => Text
                        -> TelnyxT m Request
makeTelnyxDELETERequest resourceURL =
  makeTelnyxRequest resourceURL <&> (\req -> req {
    method = "DELETE",
    checkStatus = throwForNon204
  })

throwForNon204 :: Status -> ResponseHeaders -> CookieJar -> Maybe SomeException
throwForNon204 (Status 204 _) _ _ = Nothing
throwForNon204 status responseHeaders cookieJar = Just . SomeException
  $ StatusCodeException status responseHeaders cookieJar