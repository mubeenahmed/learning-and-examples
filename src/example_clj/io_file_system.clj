(ns example-clj.io-file-system)

;; Clojure can use java file io
;; Slurp can be used directly on value io/resource

(def file "C:\\Users\\NLN\\example-clj\\src\\example_clj\\my-data.txt")

;; To read an entire file to memory
(def fetch-my-data (slurp file))
(println fetch-my-data)


;; To read the file line by line
;; We can use java io
(defn read-line-by-line []
  (with-open [rdr (clojure.java.io/reader "C:\\Users\\NLN\\example-clj\\src\\example_clj\\my-data.txt")]
    (reduce conj [] (line-seq rdr))))
(println (read-line-by-line))


(defn write-line-by-line []
  (with-open [wtr (clojure.java.io/writer "C:\\Users\\NLN\\example-clj\\src\\example_clj\\my-data.txt" :append true)]
    (.write wtr (str "\n" "this line is new"))))
(write-line-by-line)
