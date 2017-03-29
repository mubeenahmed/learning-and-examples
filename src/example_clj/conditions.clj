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