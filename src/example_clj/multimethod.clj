
;; To create the sturcture of the data for example Person has name, address

(defrecord Person [fname lname address])
(defrecord Address [town street house])


(def stu (Person. "stu" "davi" 
                  (Address. "NY" "A" "Thouse")))

(:lname stu)
(:fname stu)
(-> stu :address :town)
(-> stu :address :street)


; Create new person data structure associating the person
(assoc :person :lname "Straut")

(update-in stu [:address :zip] inc)

;; -> is the macro used to call next function in sequence.
;; When accessing Java class and it is the consecutive operation we usually 
;; uses .. for example (.. System (getProperties) (get "os.name"))
;; But we can use -> to make more readable by (-> (System/getProperties) (.get "os.name"))
(defrecord MyType [a b])
(def foo (->MyType [1 2 3] [4 5 6]))


(defn my-type [n]
    (let [a vec (range n)
          b vec (range n)] 
        (->MyType a b)))

;; Polymorphism in clojure. Multimethod is very benefical. It help you to extend operations as well as data type without 
;; changing the existing code. Full support of Open/Close Principles
(defmulti polymorphism (fn [custom-int] (:int custom-int)))
(defmethod polymorphism :small [custom-int]
           (+ (:my-int custom-int) 4))
(defmethod polymorphism :large [custom-int]
           (+ (:my-int custom-int) 400000))
         
(polymorphism {:int :small :my-int 5} )
(polymorphism {:int :large :my-int 5} )



;; Protocol are same as defmulti but the main difference is that it provides the collections of functions whereas
;; multimethod did not allow the collection of functions
(defprotocol My-Protocol 
             "THis is the doc string"
             (thoughts [x] "this function take one arguments")
             (fine [x][x y] "protocol take 2 or 1 arugments")
             (worse [x][x y][x y z] "protocol online take 2 or 1 arugments"))

(extend-type java.lang.String 
             My-Protocol  
             (thoughts [x] (str x " is the parameter"))
             (fine 
                   ([x] (str x " is the one parameter"))
                   ([x y](str x " and " y " are the two parameter")))
             (worse 
                    ([x] (str "worse with one " x))
                    ([x y](str "worse with two " x " and " y) )
                    ([x y z](str "worse with three " x "," y " and " z) )))
                 
(thoughts " Parameter1")
(fine " Parameter1" "Parameter2")
(fine " Parameter1")
(worse "1" " 2" "3")


;; Instead of extending type. We can use extend-protocol. extend-protocol let us define multiple implementations of 
;; different types
(extend-protocol My-Protocol
             java.lang.String
             (thoughts [x] (str x " is the parameter"))
             (fine 
                   ([x] (str x " is the one parameter"))
                   ([x y](str x " and " y " are the two parameter"))))
