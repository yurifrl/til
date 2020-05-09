{-# LANGUAGE OverloadedStrings #-}
module LibSpec (spec) where

import Test.Hspec
import Lib (foo)

spec = do
 describe "foo" $ do
   it "bar" $
     foo 1 `shouldBe` 1
