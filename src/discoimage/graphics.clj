(ns discoimage.graphics
  (:import [org.lwjgl.opengl GL11]))

(defn draw-ellipse
  [[x, y] radius segments]
  (let [angle (/ (* 2 Math/PI) segments)]
    (GL11/glBegin GL11/GL_POLYGON)
    (dotimes [i segments]
      (GL11/glVertex2f (->> i (* angle) Math/cos (* radius) (+ x))
        (->> i (* angle) Math/sin (* radius) (+ y))))
    (GL11/glEnd)))

(defn render
  "Renders the game."
  [picture leds states]
  nil)
