(ns playground.core
  (:require
   [playground.config :refer [config]]
   [next.jdbc :as jdbc])
  (:gen-class))

(def ds (jdbc/get-datasource (:db-spec config)))

(def rs (jdbc/execute! ds ["select * from spielpark1"]))

(get (first rs) :spielpark1/name)

(defn -main []
  (println (str "hello " (or (:name config) "stranger"))))

(comment)
(:message config)
