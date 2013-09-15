(ns discoimage.logic)

(defn picture-has-pixel?
  "Determines whether the picture has selected pixel enabled."
  [picture x y]
  (=
    1
    (-> picture
    (nth y)
    (nth x))))

(defn led-enabled?
  "Checks whether the led should be enabled."
  [picture angle led]
  (let [x (* led (Math/cos angle))
        y (* led (Math/sin angle))]
    (picture-has-pixel? picture x y)))

(defn calculate
  "Calculates the LED states."
  [picture {leds :leds} angle]
  (map (partial led-enabled? picture angle) leds))
