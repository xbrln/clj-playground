(ns playground.migrations
  (:require
   [playground.config :refer [config]]
   [migratus.core :as migratus]))

(def migrations-config {:store                :database
                        :migration-dir        "migrations/"
                        :init-script          "init.sql" ;script should be located in the :migration-dir path
                        ;defaults to true, some databases do not support
                        ;schema initialization in a transaction
                        :init-in-transaction? false
                        :migration-table-name "foo_bar"
                        :db (:db-spec config)})

;initialize the database using the 'init.sql' script
(migratus/init migrations-config)

;apply pending migrations
(migratus/migrate migrations-config)

;rollback the migration with the latest timestamp
(migratus/rollback migrations-config)

;bring up migrations matching the ids
(migratus/up migrations-config 20111206154000)

;bring down migrations matching the ids
(migratus/down migrations-config 20111206154000)

(migratus/create migrations-config "create-user")
