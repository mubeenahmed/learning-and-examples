

;; Futures
(defn factorial [n]
  (reduce +' (range 1 (inc n) )))

(def f (future (println "calculating") (factorial 200))) 
(println "another process .. ")
(println "factorial process completed" @f)
(println "done!")
