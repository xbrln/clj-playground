(ns playground.core
  (:require
   [com.brunobonacci.mulog :as u]
   [next.jdbc :as jdbc]
   [playground.config :refer [config]])
  (:gen-class))

(def ds (jdbc/get-datasource (:db-spec config)))

(def rs (jdbc/execute! ds ["select * from spielpark1"]))

; (u/start-publisher! {:type :console})
(u/start-publisher! {:type :simple-file :filename "events.log"})

(u/log ::spielpark :name (get (first rs) :spielpark1/name))

(defn -main []
  (println (str "hello " (or (:name config) "stranger"))))

(comment
  (:message config))
