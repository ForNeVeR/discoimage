(ns discoimage.graphics
  (:use clojure.tools.logging)
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

  (doseq [[led state] (map vector leds states)]
    (let [{x :x
           y :y} (logic/led-coords picture angle led)]
      (debug "render led" x y state)
      (if state
        (GL11/glColor3f 0.0 1.0 0.0)
        (GL11/glColor3f 0.0 0.1 0.0))
      (draw-ellipse [x y] 0.5))))
