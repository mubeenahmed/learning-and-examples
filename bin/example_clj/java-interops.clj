;; Java Interop
;; (.instanceMember instance args*)
;; (.instanceMember Classname args*)
;; (.-instanceField instance)
;; (Classname/staticMethod args*)
;; Classname/staticField

(.toUpperCase "Fred")
(.getName String)
(.-x (java.awt.Point. 1 2) )
(System/getProperty "java.vm.version")



(import java.util.Date)

;; Instantiate a class
(def date (Date.))
;; Instantiate a class with the arugment
(def uri (java.net.URI. "https://illuxplain-mubeen.rhcloud.com/"))

;; Invoking instance with the method call
(println (. date getTime))
;; More convient way to invoke a method 
(println (.getTime date))

;; If you want to chain the functions
(println (.. (java.util.Date.) getTime toString) )


;; Multiple calls on java object
(doto (java.util.Stack.)(.push 1)(.push 3)(.push 5) )


;; Determine the class of Java Object
(class 1)
(class "String")
(class 1.025)


;; How to set the fields in Java POJO class
(let [pt (java.awt.Point. 1 1) ]
  (println (.-x pt))
  (set! (.-x pt) 100)
  (println (.-x pt)))

