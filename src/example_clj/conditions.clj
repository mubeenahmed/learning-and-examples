(ns example-clj.conditions)

;two values are false in clojure (nil and false). Other all values are true
(defn is-small [x] 
  (if (< x 0)
    "less than zero"
    "greater or equal to zero"))

(println (is-small 10))
(println (is-small 100))

;Takes a set of test/expr pairs.
; :else is the keyword by clojure. In here it is for else
(defn pos-neg-or-zero [n]
  (cond 
    (> n 0)
    "positive"
    (< n 0)
    "negative"
    :else
    "zero"))

(println (pos-neg-or-zero 2))
(println (pos-neg-or-zero -5))
(println (pos-neg-or-zero 0))


(defn is-in-range? [r1 r2 v] 
  (and (>= v r1)(<= v r2) ) )

(defn grading [cgpa]
  (cond 
        (is-in-range? 2.00 2.25 cgpa) "D"
        (is-in-range? 2.26 2.50 cgpa) "C"
        (is-in-range? 2.51 2.75 cgpa) "B"
        (is-in-range? 2.76 3.50 cgpa) "A"
        (is-in-range? 3.51 4.00 cgpa) "A"
        :else "F" ))

(grading 2.75) ;; B
(grading 3.75) ;; A
(grading 1.99) ;; F
