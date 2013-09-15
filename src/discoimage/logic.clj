(ns discoimage.logic
  (:use clojure.tools.logging))

(defn picture-width
  "Determine X dimension of the picture."
  [picture]
  (count (picture 0)))

(defn picture-height
  "Determine Y dimension of the picture."
  [picture]
  (count picture))

(defn picture-has-pixel?
  "Determines whether the picture has selected pixel enabled."
  [picture x y]
  (let [y-index (- (picture-height picture) y 1)
        value (-> picture
                (nth y-index)
                (nth x))]
    (= value 1)))

(defn led-coords
  "Determine absolute coordinates of LED."
  [picture angle led]
  (let [center-x (/ (picture-width picture) 2)
        center-y (/ (picture-height picture) 2)
        x (+ center-x (* led (Math/cos angle)))
        y (+ center-y (* led (Math/sin angle)))]
    {:x x
     :y y}))

(defn led-enabled?
  "Checks whether the led should be enabled."
  [picture angle led]
  (let [{x :x
         y :y} (led-coords picture angle led)]
    (picture-has-pixel? picture (Math/floor x) (Math/floor y))))

(defn calculate-leds
  "Calculates the LED states."
  [picture leds angle]
  (map (partial led-enabled? picture angle) leds))
