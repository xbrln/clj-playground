(ns playground.csv
  (:require
   [clojure.data.csv :as csv]
   [clojure.java.io :as io]
   [clojure.string :as str]))

(defn read-csv
  "Takes file name and reads data."
  [fname]
  (with-open [reader (io/reader fname)]
    (doall
     (csv/read-csv reader))))

(defn write-csv
  "Write to given csv file from given input"
  [f i]
  (with-open [writer (io/writer f)]
    (csv/write-csv writer i)))

(comment
  (def firebase-users (read-csv "/Users/j.kurisingal/HolidayPirates/Data-export/firebase-users-all.csv"))

  (def braze-users (read-csv "/Users/j.kurisingal/HolidayPirates/Data-export/Braze-users-with-custom-attributes.csv"))

  (def braze-users (read-csv "/Users/j.kurisingal/HolidayPirates/Data-export/Braze-user-emails.csv"))

  (def iterable-users (read-csv "/Users/j.kurisingal/HolidayPirates/Data-export/Iterable-user-data.csv"))

  (def result (filter (fn [x] (not (str/blank? (get x 0)))) (rest iterable-users)))

  (count result)

  (def list-1 '(["abc" "123" ""]
                ["ytr" "4" ""]))

  (def list-2 '(["" "" "" "abc"]
                ["" "" "" "def"]))

  (take 2 iterable-users)

  (write-csv
   "/Users/j.kurisingal/HolidayPirates/Data-export/iterable-users-1.csv"
   (map (fn [x] (take 1 x)) (rest iterable-users))))
