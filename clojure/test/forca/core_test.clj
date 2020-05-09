(ns forca.core-test
  (:require [clojure.test :refer :all]
            [forca.core :refer :all]))

(deftest game-test
  (testing "Game"
    (is (= "win" (game 5 "MELANCIA" #{"M" "E" "L" "A" "N" "C" "I"})))
    (is (= "try" (game 5 "MELANCIA" #{"A"})))
    (is (empty? (missing-letters "MELANCIA" #{"M" "E" "L" "A" "N" "C" "I"})))
    ))
