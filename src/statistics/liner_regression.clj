(ns statistics.liner_regression)
(use '(incanter core stats io datasets charts))


(with-data (read-xls "D:\\eclipse-workspace\\learning-and-examples\\src\\statistics\\regression.xlsx")
 (let [x ($ :x) 
       y (sweep ($ :y))] 
   (def plot (scatter-plot x y) )
   (view plot)
   ;(def X (reduce bind-columns (for [i (range 1 11)] (pow x i))))
   (def coefs (:coefs lm))
   (def lm (linear-model y x))
   (def next-x (inc (last x)))
   (def new-y (next-y (slope coefs) (intercept coefs) next-x))
   (add-points plot [next-x] [new-y])
   (add-lines plot x (:fitted lm))))

(defn slope [coefs] 
  (second coefs))
(defn intercept [coefs]
  (first coefs))
(defn next-y [slope intercept x]
  (+ intercept (* slope x) ))


;; Learning Example
;;;;;;;;;;;;;;;;;;;;; 

;(def data (to-matrix (get-dataset :filip)))
;(def y (sel data :cols 0))
;(def x (sweep (sel data :cols 1)))
;
;(def plot (scatter-plot x y))
;(view plot)
;
;(def X (reduce bind-columns (for [i (range 1 11)] (pow x i))))
;(def lm (linear-model y X))
;
;; view the results
;
;; view the overall model fit
;(:f-stat lm) ;; 2162.439
;(:f-prob lm) ;; 1.1E-16
;
;; view the R^2 of the model
;(:r-square lm) ;; 0.997
;
;; view the estimates of the coefficients
;(:coefs lm)
;; (0.878 0.065 -0.066 -0.016 0.037 0.003 -0.009 -2.8273E-4 9.895E-4 1.050E-5 -4.029E-5)
; 
;; view the p-values for each of the coefficients
;(:t-probs lm)
;; (0 0 0 1.28E-5 0.0 0.083 1.35E-12 0.379 3.74E-8 0.614 2.651E-5)
;
;
;(add-points plot x (:fitted lm))