(ns basic-stats)

;; Some sample data
(def heights [600 470 170 430 300] )

;; Calculating the means
(def means (/ (reduce + heights) (count heights) ))

;; Calculating the variance by Sum of ( Mean - X ) and powering by 2.s 
(def variance (/ (reduce + (map #(Math/pow (- means %) 2) heights)) (count heights)) )

;; Calcuating the standard deviation by square root
(def standard-deviation (Math/sqrt variance) )


(println means)
(println variance)
(println standard-deviation)
