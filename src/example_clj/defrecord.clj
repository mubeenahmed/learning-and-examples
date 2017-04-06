
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

;; -> implement directly defrecord

(defrecord MyType [a b])
(def foo (->MyType [1 2 3] [4 5 6]))


(defn my-type [n]
    (let [a vec (range n)
          b vec (range n)] 
        (->MyType a b)))
