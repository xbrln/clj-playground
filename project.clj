(defproject
 playground "0.1.0"
 :description "An example project to try out all the different libraries"
 :url "http://example.com/FIXME"
 :dependencies [[aero "1.1.6"]
                [clojure-csv "2.0.2"]
                [com.brunobonacci/mulog "0.8.1"]
                [com.github.seancorfield/next.jdbc "1.2.731"]
                [migratus "1.3.5"]
                [org.clojure/clojure "1.10.3"]
                [org.postgresql/postgresql "42.3.0"]]

 :min-lein-version "2.0.0"
 :main ^:skip-aot playground.core

 :plugins [[migratus-lein "0.7.3"]]

 :migratus {:store :database
            :migration-dir "migrations"
            :db {:dbtype "postgres"
                 :dbname "playground"
                 :user "playground"
                 :password (get (System/getenv) "DB_PASSWORD")
                 :port 5433
                 :serverTimezone "CET"}}

 :profiles
 {:uberjar
  {:aot :all
   :uberjar-name "app-standalone.jar"}

  :dev {}
  :test {}})
