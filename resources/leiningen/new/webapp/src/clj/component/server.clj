(ns {{name}}.component.server
  (:require [com.stuartsierra.component :as component]
            [org.httpkit.server :refer [run-server]]))

(defrecord Server [handler]
  component/Lifecycle
  (start [component]
    (println ";; Starting server")
    (if (:server component)
      component
      (let [options (dissoc component :handler)
            server (run-server (:handler handler) options)]
        (println "Started server on port" (:port component))
        (assoc component :server server))))
  (stop [component]
    (println ";; Stopping server")
    (when-let [server (:server component)]
      (server :timeout 100)
      (dissoc component :server))))

(defn new-server
  [options]
  (map->Server options))
