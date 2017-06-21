(ns example-clj.future-promise)

;; Futures, runs in the background thread in a thread pool. Future is the execution of some operation
;; asynchoronusly. When the deref of the future is performed, it is blocked
(defn factorial [n]
  (reduce +' (range 1 (inc n) )))

(def f (future (println "calculating") (factorial 200))) 
(println "another process .. ")
(println "factorial process completed" @f)
(println "done!")


;; Promise, is also the asynchoronus operation. But until the promise has not finished with operation
;; and delivered is performed then it will block the thread
;; Promise are delivered once, and once delivered they cannot be reuse.
;; Promise encapsulate the immutable data
;; Promise is thread-safe and its value cannot be changed once delivered or set
(defn long-running-op []
  (do (Thread/sleep 200) 20))

(def answer (promise))
(deliver answer (long-running-op))

(println "some other process")
(println "long running operation ends with " @answer)
(println "done!")
