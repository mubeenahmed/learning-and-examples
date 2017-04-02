(ns example-clj.loop)

;for loop is the imperative style. To implement declarative loop 
;we have recursion or map

(defn m-loop []
	(loop [x 10]
	  (when (> x 1)
	    (println x)
	    (println "done")
	    (recur (- x 2)))))

(m-loop)


;factorial, tail recursion. The loop has two different binding one is set to loop iterator and other is set to 1 for initate.
(defn fact [x]
  (loop [n x f 1]
    (if (= n 1)
      f
      (recur (dec n)(* f n)))))


;factorial for larger number we need to use arbitary precision. Clojure support this very easily through *'
;the range return the list of 1 to n and reduce multiple each number.
;it is also the clean way to write without loop and recurrsion
(defn fact-2 [n]
  (reduce *' (range 1 (inc n))))

(println (fact 5))


; list comprehension
(defn list-comp []
	(for [number [1 2 3]
	  letter [:a :b :C]]
	  (str number letter)))
(println (list-comp))


(def cap-letters (map char (range (int \A)(int \Z) )))
(def blacklists-letters #{\I \O})
(defn letters-filters [] 
  (for [letter-1 cap-letters
      letter-2 cap-letters
      :when (and (not (blacklists-letters letter-1))
                 (not (blacklists-letters letter-2)))]
  (str letter-1 letter-2)))






