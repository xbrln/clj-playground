(ns playground.migrations
  (:require
   [environ.core :refer [env]]
   [migratus.core :as migratus]))

(def config {:store                :database
             :migration-dir        "migrations/"
             :init-script          "init.sql" ;script should be located in the :migration-dir path
             ;defaults to true, some databases do not support
             ;schema initialization in a transaction
             :init-in-transaction? false
             :migration-table-name "foo_bar"
             :db {:dbtype "postgres"
                  :dbname "playground"
                  :user "playground"
                  :password (env :db-password)
                  :port 5433
                  :serverTimezone "CET"}})

;initialize the database using the 'init.sql' script
(migratus/init config)

;apply pending migrations
(migratus/migrate config)

;rollback the migration with the latest timestamp
(migratus/rollback config)

;bring up migrations matching the ids
(migratus/up config 20111206154000)

;bring down migrations matching the ids
(migratus/down config 20111206154000)

(migratus/create config "create-user")
