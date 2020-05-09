4
(+ 40 2)
;; (define (square x) (* x x))
(define square (lambda (x) (* x x))
(square 10)
(define a (+ 5 5))
; a -> 25
; (a) -> error
(define (d) (+ 5 5))
; d -> compound procedure d
; (d) -> 25
