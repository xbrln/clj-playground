(ns playground.core
  (:require
   [clojure-csv.core :as csv]
   [clojure.java.io :as io]
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

(defn take-csv
  "Takes file name and reads data."
  [fname]
  (with-open [file (io/reader fname)]
    (-> file
        (slurp)
        (csv/parse-csv))))

(comment
  (:message config)
  (def csv (take-csv "/Users/j.kurisingal/Downloads/DE_-_Spectacular_export.csv"))
  (def emails (map (fn [i] (nth i 3)) (rest csv)))
  (take 10 emails))
