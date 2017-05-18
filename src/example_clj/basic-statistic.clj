(ns basic-stats)

;; Some sample data
(def heights [600 470 170 430 300] )

;; Need the count in multiple places for calculating means and variance
(def c (count heights))

;; Calculating the means
(def means (/ (reduce + heights) c ))

;; Calculating the variance by Sum of ( Mean - X ) and powering by 2.s 
(def variance (/ (reduce + (map #(Math/pow (- means %) 2) heights)) c) )

;; Calcuating the standard deviation by square root
(def standard-deviation (Math/sqrt variance) )


(println means)
(println variance)
(println standard-deviation)
