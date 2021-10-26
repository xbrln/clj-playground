(defproject
 playground "0.1.0"
 :description "Example project"
 :url "http://example.com/FIXME"
 :dependencies [[com.github.seancorfield/next.jdbc "1.2.731"]
                [environ "1.2.0"]
                [migratus "1.3.5"]
                [org.clojure/clojure "1.10.3"]
                [org.postgresql/postgresql "42.3.0"]]

 :min-lein-version "2.0.0"
 :main ^:skip-aot playground.core

 :plugins [[lein-environ "1.2.0"]
           [migratus-lein "0.7.3"]]

 :migratus {:store :database
            :migration-dir "migrations"
            :db {:dbtype "postgres"
                 :dbname "playground"
                 :user "playground"
                 ; :password (environ.core/env :db-password)
                 :password (get (System/getenv) "DB_PASSWORD")
                 :port 5433
                 :serverTimezone "CET"}}

 :profiles
 {:uberjar
  {:aot :all
   :uberjar-name "app-standalone.jar"}

  :dev [:project/dev :profiles/dev]
  :test [:project/test :profiles/test]

  :project/dev {}
  :project/test {}
  :profiles/dev {}
  :profiles/test {}})
