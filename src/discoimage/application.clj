(ns discoimage.application
  (:require [discoimage.window :as window]))

(defn -main [& args]
  (let [picture [[1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
                 [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
                 [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
                 [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
                 [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
                 [0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0]
                 [0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0]
                 [0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0]
                 [0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0]
                 [0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0]
                 [0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0]
                 [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                 [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                 [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                 [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
                 [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]]
        leds [0.5 1 1.5 2 2.5 3 3.5 4 4.5 5 5.5 6 6.5 7 7.5]
        frequency 59]
    (window/start picture leds frequency)))
