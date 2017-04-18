(ns example-clj.future-promise)

;; Futures, runs in the background thread in a thread pool. Future is the execution of some operation
;; asynchoronusly. When the deref of the future is performed, it is blocked
(defn factorial [n]
  (reduce +' (range 1 (inc n) )))

(def f (future (println "calculating") (factorial 200))) 
(println "another process .. ")
(println "factorial process completed" @f)
(println "done!")
