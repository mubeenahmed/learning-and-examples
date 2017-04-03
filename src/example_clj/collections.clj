(ns example-clj.collections)

;; List
;; This is the simple link list implemented. 
;; Therefore complexity is for simple link list
(println '(1 2 3 4))
;; OR
(println (list 1 2 3 4))

;; Vector
;; This is the red black search binary three. 
;; It is the recommended way to store data
(println [1 2 3 4])
(println [:a :b :C :d])

;; Hash Maps and Sorted Maps;
;; These are the datastructures with the key and values
(println (hash-map :key1 1 :key2 2))
(println {:key1 1 :key2 2})
(println (sorted-map :key2 1 :key1 2))


;; Set
;; These are the distinct values
;; It works on every data structure
(println (set [1 2 3 4 4 5 2]))
(println (set {:one 1 :two 2 :three 3}))
(println (set "abcd"))
(println '(1 2 3 4 3))

;;
(println (map #(* %1 2) [1 2 3] ) )
(println (map #(* %1 2) '(1 2 3) ) )


(println (reduce + [1 2 3]))


;; Conj, adds new value to the existing data structure and return new data structure
(println (conj [1 2 3] 4))
(println (conj '(1 2 3) 4))
(println (conj [[1 2] [3 4]] [5 6]))
; conjoining with map only takes vector with exactly 2 data
(println (conj {1 2 3 4} [1 2]))
(println (conj {:firstname "John" :lastname "Doe"} {:age 25 :nationality "Chinese"}))
