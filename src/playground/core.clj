(ns playground.core
  (:require
   [environ.core :refer [env]])
  (:gen-class))

(defn -main []
  (println (str "hello " (env :name))))

(comment
  (env :abc))
