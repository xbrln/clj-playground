(ns playground.core
  (:require
   [environ.core :refer [env]]
   [next.jdbc :as jdbc])
  (:gen-class))

(def db-spec {:dbtype "postgres"
              :dbname "playground"
              :user "playground"
              :password (env :db-password)
              :serverTimezone "CET"})

(def ds (jdbc/get-datasource db-spec))

(def rs (jdbc/execute! ds ["select * from spielpark1"]))

(get (first rs) :spielpark1/name)

(defn -main []
  (println (str "hello " (env :name))))

(comment
  (env :abc))
