{-#LANGUAGE DataKinds #-}
{-#LANGUAGE DeriveDataTypeable #-}
{-#LANGUAGE DeriveGeneric #-}
{-#LANGUAGE GeneralizedNewtypeDeriving #-}
{-#LANGUAGE TemplateHaskell #-}

module Telnyx.Types.SIDs
  ( AccountSID(..)
      -- * Smart Constructors
  , mkAccountSID
  , module Twilio.Types.SID
  ) where