(ns discoimage.graphics
  (:import [org.lwjgl.opengl GL11])
  (:require [discoimage.logic :as logic]))

(defn draw-ellipse
  [[x, y] radius]
  (let [angle (/ (* 2 Math/PI) 8)]
    (GL11/glBegin GL11/GL_POLYGON)
    (dotimes [i 8]
      (GL11/glVertex2f (->> i (* angle) Math/cos (* radius) (+ x))
        (->> i (* angle) Math/sin (* radius) (+ y))))
    (GL11/glEnd)))

(defn render
  "Renders the game."
  [picture leds angle states]

  (GL11/glClear GL11/GL_COLOR_BUFFER_BIT)

  (doseq [led leds
          state states]
    (let [{x :x
           y :y} (logic/led-coords picture led angle)]
      (if state
        (GL11/glColor3f 0.0 1.0 0.0)
        (GL11/glColor3f 0.0 0.5 0.0))
      (draw-ellipse [x y] 0.5))))
