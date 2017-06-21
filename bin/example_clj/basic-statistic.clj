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
;; Why we square root the variance, because we need to find the 
;; root from which there is the variance in the heights or data
;; square root helps to find the margin from which the variance
;; occurred
(def standard-deviation (Math/sqrt variance) )

;; zero-score help to calculate the probability of a score occurring in normal distribution
;; compare the score from differen normal distribution
;; zero-score converts to group of frequences such that the mean is between 0 and 1
(defn zero-score [x mean sd]
  (/ (- x mean) sd))
(zero-score 470 means standard-deviation)


(println means)
(println variance)
(println standard-deviation)
