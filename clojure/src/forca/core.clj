;; Namespace
(ns forca.core
  (:gen-class))


(def lifes-total 6)

(defn lost [] (do (print "You loose") "lost"))
(defn win [] (do (print "You win") "win"))
(defn missing-letters [word guesses]
  (remove (fn [letter] (contains? guesses (str letter))) word)
)

(defn guessed-entire-word? [word guesses]
  (empty? (missing-letters word guesses))
)

(defn game [lifes word guesses]
  (if (= lifes 0)
    (lost)
    (if (guessed-entire-word? word guesses)
      (win)
      (do (print "Take a guess budy!") "try")
    )
  )
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
