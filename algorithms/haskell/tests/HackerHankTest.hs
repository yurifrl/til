module HackerHankTest where

import Test.Tasty
import Test.Tasty.HUnit
import Test.Tasty.SmallCheck as SC

import HackerHank

main = defaultMain tests

tests :: TestTree
tests = testGroup "Testing HackerHank" [unitTests]
-- tests = testGroup "Testing HackerHank" [properties, unitTests]

-- properties = testGroup "Properties (tested via SmallCheck)"
--     [ SC.testProperty "Test one implementation against another" $
--         \list -> pureSolveMeFirst (list :: [String]) == pureSolveMeFirst list
--     ]

-- unitTests = testGroup "Tests (run via HUnit)"
--     [ testCase "pureSolveMeFirst" $
--         (assertEqual "pureSolveMeFirst (1 2 3)" "6" (pureSolveMeFirst "1 2 3"))
--     ]

unitTests = testGroup "Tests (run via HUnit)"
    [ testCase "compare" $
        [1, 2, 3] `compare` [1, 2] @?= GT
    , testCase "length" $
        length [1, 2, 3] @?= 3
    ]
