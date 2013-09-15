(defproject discoimage "0.1.0-SNAPSHOT"
  :description "POV display image generator."
  :url "https://github.com/ForNeVeR/discoimage"
  :license {:name "MIT License"
            :url "http://www.opensource.org/licenses/mit-license.php"}
  :dependencies [[log4j/log4j "1.2.17"]
                 [org.clojars.rexim/lwjgl-platform-natives "2.8.4"]
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.3"]
                 [org.lwjgl.lwjgl/lwjgl "2.8.4"]]
  :main discoimage.application)
