(ns example-clj.example)

; Using fn (anonymous function) with map
(def powered (map (fn [x] (* x x)) [1 2 3 4]) )

(print "\n" powered)

;Short of anonymous function can be used by #
;No argument
(#(print "\n" "Hello" "World"))
;1 argument
(#(println "Hello" %) "World")
;2 argument
(#(println "Hello" %1 %2) "Beautiful" "World")
;more argument
(#(println "Hello" %&) "many" "argumments")


;Higher order function
(defn add [x y]
  (+ x y))
(defn sub [x y]
  (- x y))

(defn calculate [f x y]
  (f x y))

(println (calculate add 1 1))
(println (calculate sub 2 1))

;let create the lexical binding of data structures to symbols. the binding is avialable only within the lexical context
;let is also used in destructuring 
;Simple let
(let [x 1]
  x)
(let [x 1 y 2]
  (+ x y))

(defn with-let [x1] 
  (let [x2 (+ x1 x1)]
  (+ x2 x1)))
(println "with-let" (with-let 1))






