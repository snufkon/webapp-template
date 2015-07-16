(ns {{name}}.component.database
  (:require [com.stuartsierra.component :as component]))

(defn- mysql
  [{:keys [host port db make-pool?]
    :or {host "localhost", port 3306, db "", make-pool? true}
    :as opts}]
  (merge {:classname "com.mysql.jdbc.Driver"
          :subprotocol "mysql"
          :subname (str "//" host ":" port "/" db)
          :delimiters "`"
          :make-pool? make-pool?}
         opts))

(defrecord Database [config]
  component/Lifecycle
  (start [component]
    (println ";; Starting database")
    (if (:db-spec component)
      component
      (let [db-spec (mysql config)]
        (assoc component :db-spec db-spec))))
  (stop [component]
    (println ";; Stopping database")
    (dissoc component :db-spec)))

(defn new-database
  [config]
  (map->Database {:config config}))
