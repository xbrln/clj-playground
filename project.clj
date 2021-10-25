(defproject
 playground "0.1.0"
 :description "Example project"
 :url "http://example.com/FIXME"
 :dependencies [[org.clojure/clojure "1.10.3"]
                [environ "1.2.0"]]
 :min-lein-version "2.0.0"
 :main ^:skip-aot playground.core

 :plugins [[lein-environ "1.2.0"]]

 :profiles
 {:uberjar
  {:aot :all
   :uberjar-name "app-standalone.jar"}

  :dev [:project/dev :profiles/dev]
  :test [:project/test :profiles/test]

  :project/dev
  {:plugins []}
  :project/test {}
  :profiles/dev {}
  :profiles/test {}})
