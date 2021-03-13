{-#OPTIONS_GHC -w #-}
{-#LANGUAGE OverloadedStrings #-}
{-#LANGUAGE ScopedTypeVariables #-}

module Main where

import Control.Monad.IO.Class (liftIO)
import System.Environment (getEnv)
import Telnyx
import Telnyx.Calls as Calls
import Telnyx.Messages

main :: IO ()
main = runTelnyx' (getEnv "ACCOUNT_SID")
                  (getEnv "AUTH_TOKEN") $ do
  -- Print Calls.
  calls <- Calls.get
  liftIO $ print calls

  -- Send a Message.
  let body = PostMessage "+14158059869" "+14158059869" "Oh, hai" Nothing
  message <- post body
  liftIO $ print message