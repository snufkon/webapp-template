(ns {{name}}.component.handler
  (:require [com.stuartsierra.component :as component]
            [compojure.core :as compojure]))

(defn- find-routes
  [component]
  (keep :routes (vals component)))

(defrecord Handler []
  component/Lifecycle
  (start [component]
    (println ";; Starting handler")
    (if (:handler component)
      component
      (let [routes (find-routes component)
            handler (apply compojure/routes routes)]
        (assoc component :handler handler))))
  (stop [component]
    (println ";; Stopping handler")
    (dissoc component :handler)))

(defn new-handler
  []
  (map->Handler {}))
