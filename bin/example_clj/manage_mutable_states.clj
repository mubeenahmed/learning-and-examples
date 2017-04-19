(ns example-clj.mutables)

;; Most of the data structures are immutable
;; However, clojure give the features to make mutable in safe way

(def the-world (ref "good"))
(println @the-world)


;; to create the transaction use dosync
(defn transaction [] 
	(do 
	  (dosync (ref-set the-world "better")
	    @the-world)))

(println transaction)

(let [fn #(str % "!") ] 
  (dosync
    (alter the-world fn)
    @the-world))


(def second-world (ref {}))
(let []
  (do
    (dosync
      (ref-set the-world {})
      (alter the-world assoc :jerry "Real Jery")
      (alter second-world assoc :jerry "Fake Jerry")
      [(:jerry @the-world)(:jerry @second-world)])))


;; atom are analogous to ref, the difference is that it 
;; is not perform in transactional way
;; atom are the way to provide the shared, synchronous, independent state
(def atomic-clock (atom 0))
(println @atomic-clock)


;; swap! notice the excalamination mark(!) which means that this has the side effects
;; the swap! macro takes the function as a argument
(swap! atomic-clock inc)
(println @atomic-clock)
(swap! atomic-clock + 1 2 3 4 5)
(println @atomic-clock)

(do 
  (compare-and-set! atomic-clock 100 :fin))

(println @atomic-clock)

(do 
  (compare-and-set! atomic-clock 16 :fin))

(println @atomic-clock)

;; Agent, provide shared access to mutable state. They allow non-blocking asynchoronus, unlike ref. They are 
;; opposed to atom which provide synchronous
(def a (agent 0) )

;; send request to change its value
(send a inc)
(send a inc)
(send a inc)
@a



