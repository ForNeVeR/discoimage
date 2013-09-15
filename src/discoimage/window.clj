(ns discoimage.window
  (:use clojure.tools.logging)
  (:import [org.lwjgl Sys]
           [org.lwjgl.opengl Display DisplayMode GL11]
           [org.lwjgl.input Mouse Keyboard])
  (:require [discoimage.graphics :as graphics]
            [discoimage.logic :as logic]))

(def fps 60)

(defn get-time []
  "Returns current time in seconds."
  (/ (Sys/getTime)
    (Sys/getTimerResolution)))

(defn normalize-angle
  "Normalize angle to [0; 2PI]."
  [initial-angle]
  (loop [angle initial-angle]
    (if (< angle 0)
      (recur (+ angle (* 2 Math/PI)))
      (if (> angle (* 2 Math/PI))
        (recur (- angle (* 2 Math/PI)))
        angle))))

(defn initialize
  "Initialize the window."
  [width height world-size]

  ;; Create display
  (Display/setDisplayMode (DisplayMode. width height))
  (Display/create)

  ;; Init OpenGL
  (GL11/glMatrixMode GL11/GL_PROJECTION)
  (GL11/glLoadIdentity)
  (GL11/glOrtho 0 world-size
    0 world-size
    1 -1)
  (GL11/glMatrixMode GL11/GL_MODELVIEW))

(defn gl-loop
  [picture leds frequency]
  (loop [time (get-time)
         angle 0]
    (if (Display/isCloseRequested)
      (Display/destroy)
      (let [new-time (get-time)
            delta-time (- new-time time)
            delta-angle (* frequency delta-time Math/PI 2)
            new-angle (normalize-angle (+ angle delta-angle))
            states (logic/calculate-leds picture leds new-angle)]

        (graphics/render picture leds new-angle states)
        (Display/update)
        ;(Display/sync fps)
        (recur new-time new-angle)))))

(defn start
  "Starts the graphical simulation."
  [picture leds frequency]
  (initialize 600 600 16)
  (gl-loop picture leds frequency))
