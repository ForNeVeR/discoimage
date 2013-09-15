(ns discoimage.logic-test
  (:require [clojure.test :refer :all]
            [discoimage.logic :refer :all]))

(deftest picture-has-pixel-test
  (testing "Testing picture-has-pixel function."
    (is (true? (picture-has-pixel? [[1]] 0 0)))
    (is (true? (picture-has-pixel? [[1 0]
                                   [0 1]] 1 1)))
    (is (false? (picture-has-pixel? [[1 0]
                                    [0 1]] 0 1)))))

(deftest led-enabled-test
  (testing "Testing led-enabled function."
    (let [picture [[1 0]
                   [0 1]]]
      (is (false? (led-enabled? picture 0.5 (* 1/4 Math/PI))))
      (is (true? (led-enabled? picture 0.5 (* 3/4 Math/PI)))))))
