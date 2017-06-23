(ns statistics.basics)
(use '(incanter core stats io datasets charts))

;; Some sample data
(def heights [600 470 170 430 300] )

;; Need the count in multiple places for calculating means and variance
(def total (count heights))
(def means (/ (reduce + heights) total ))
(def vari (/ (reduce + (map #(Math/pow (- means %) 2) heights)) total) )
(def standard-deviation (Math/sqrt vari) )

(defn zero-score [x mean sd]
  (/ (- x mean) sd))
(zero-score 470 means standard-deviation)



(println means)
(println vari)
(println standard-deviation)

(doto 
  (scatter-plot [1 2 3 4 5] heights)
  (add-lines 0 means)
  view)