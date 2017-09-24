(ns example-clj.dependencies-injection)

;; Dependencies injection are the simple use of functional composition
;; This injection of function into another function provides
;; lossely couple of functions

(defn calc [f a b]  
  (f a b) )


(calc + 2 3)
(calc - 2 3)
(calc / 2 3)
(calc * 2 3)
(calc str "Two " " Strings!")
(calc filter even? [1 2 3 4 5] )