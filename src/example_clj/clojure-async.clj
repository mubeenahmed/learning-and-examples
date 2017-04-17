
(require '[clojure.core.async :as async :refer :all])

;; First we need to create the channel
;; Optional arguments is the buffer size. If the data to be buffered is more than the provided then it will be blocked
;; Channel is similar to a queue 
(def capacity 10)
(def m-channel (chan capacity))
(def stock-map {0 :shirt 10 :pants 40 :skirts 1 :socks} )

(defn generate-items []
  (let [items (for [x (range capacity)] (rand-int (count (keys stock-map))))]
    (map #(get stock-map %) items)))

;; >!! is the the symbol for sending into the chaneel and it is blocking
(defn load-items-into-channel [items channel]
  (map #(>!! channel %) items))

(load-items-into-channel (generate-items) m-channel)


;; <!! is the pulling of the item from the channel 
;; if there is no item in the channel. 
;; It will block the thread and wait for the item to be avialable in channel


;; Parking helps to make the process into thread pool 
;; GO macro helps to make the task aysnc

