(ns playground.config
  (:require
   [aero.core :as aero]))

(def config (aero/read-config (clojure.java.io/resource "config.edn")))
