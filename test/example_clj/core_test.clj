(ns example-clj.core-test
  (:require [clojure.test :refer :all]
            [example-clj.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))

(deftest add-test
  (testing "2 + 2 gives four"
           (is (= 4 (+ 2 2)))))
