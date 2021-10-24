(ns playground.core-test
  (:require [clojure.test :refer :all]
            [playground.core :refer :all]))

(deftest main-test
  (testing "If main function returns nil."
    (is (= nil (-main)))))
