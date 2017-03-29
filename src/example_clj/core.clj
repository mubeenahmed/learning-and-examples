(ns example-clj.core)

; Def, Creates local or locates a global var with the name of symbol and a namespace of value of the current ns
; Clojure var binding. It is immutable i.e. it cannot be reassign, String
(def my-var-string "a string")

; Clojure var binding. It is immutable i.e. it cannot be reassign, Integer
(def my-var-integer 1)

; Clojure var binding. It is immutable i.e. it cannot be reassign, Float
(def my-var-float 1.23)

(print "\n" my-var-string)
(print "\n" my-var-integer)
(print "\n" my-var-float)



;Defn, is to defn the function. It creates local or locates a global function with the name of symbol and a namespace of value of the current ns
(defn my-function []
  (print "\n" "my-function with no arg"))

(defn my-function-one-arg [a]
  (print "\n" "my-function with one arg" a))

(defn my-function-two-arg [a b]
  (print "\n" "my-function with no arg" a b))

(defn my-function-many-arg [& more]
  (print "\n" "my-function with many arg" more))

(defn special-func 
  ([] (+ 10 10))
  ([x] (+ x 10))
  ([x y](+ x y)))

(my-function)
(my-function-one-arg 1)
(my-function-two-arg 1 1)
(my-function-many-arg 1 1 1 1)
(special-func 1 1)
(special-func 1 )
(special-func)









