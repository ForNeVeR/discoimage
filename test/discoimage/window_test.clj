(ns discoimage.window-test
  (:require [clojure.test :refer :all]
            [discoimage.window :refer :all]))

(deftest normalize-angle-test
  (testing "Testing normalize-angle function."
    (is (= 0 (normalize-angle 0)))
    (is (= 1.0 (normalize-angle (+ (* 2 Math/PI) 1))))
    (is (= Math/PI (normalize-angle Math/PI)))
    (is (= Math/PI (normalize-angle (- Math/PI))))))
