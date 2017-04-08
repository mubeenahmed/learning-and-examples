(def coordes [10 20 30])

(let [x (first coordes)
      y (second coordes)
      z (last coordes)])
      
(let [[x y z] coordes]
     (+ x y z))
   
   
(def my-list '("orange" "mango" "apple"))
(let [[l-1 l-2 l-3] my-list]
     (str l-3 l-2 l-1))
   
(def my-name "Mubeen")
(let [[chr-1 _ chr-3] my-name]
     (str chr-1 chr-3))
   
(let [ [list-1 _ list-3 :as fruits] my-list]
     (str list-1 list-3))
   
(def my-coords {:x 10 :y 20 :z 30} )
(let [{x :x y :y z :z} my-coords]
     (+ x y z))
   
(let [{:keys [x y z] } my-coords]
     (+ z y x))


(let [ {:keys [x y z] :or {x 100 y 200 z 300} } {:z 50} ]
     (+ x y z))


