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
