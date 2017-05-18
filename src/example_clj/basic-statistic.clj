(ns basic-stats)

;; Some sample data
(def heights [600 470 170 430 300] )

;; Need the count in multiple places for calculating means and variance
(def c (count heights))

;; Calculating the means
(def means (/ (reduce + heights) c ))

;; Calculating the variance by Sum of ( Mean - X ) and powering by 2
;; Why we square the difference, because we need the positive number
;; This is similar to calculating the distance as the distance cannot be in negative
;; Before sum the result of difference, it is need to eliminate the negative number
;; This applies for the variance
(def variance (/ (reduce + (map #(Math/pow (- means %) 2) heights)) c) )

;; Calcuating the standard deviation by square root
(def standard-deviation (Math/sqrt variance) )


(println means)
(println variance)
(println standard-deviation)
