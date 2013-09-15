(ns discoimage.logic-test
  (:require [clojure.test :refer :all]
            [discoimage.logic :refer :all]))

(deftest picture-has-pixel-test
  (testing "Testing picture-has-pixel function."
    (is (true? (picture-has-pixel? [[1]] 0 0)))
    (is (true? (picture-has-pixel? [[1 0]
                                    [0 1]] 1 0)))
    (is (false? (picture-has-pixel? [[1 0]
                                     [0 1]] 1 1)))))

(deftest led-coords-test
  (testing "Testing led-coords function"
    (is (= 10.0 (:x (led-coords [[]] 0 10))))))

(deftest led-enabled-test
  (testing "Testing led-enabled function."
    (let [picture [[1 0]
                   [0 1]]]
      (is (false? (led-enabled? picture (* 1/4 Math/PI) 0.5)))
      (is (true? (led-enabled? picture (* 3/4 Math/PI) 0.5))))))
