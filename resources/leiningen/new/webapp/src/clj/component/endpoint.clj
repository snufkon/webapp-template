(ns {{name}}.component.endpoint
  (:require [com.stuartsierra.component :as component]))

(defrecord Endpoint [build-routes]
  component/Lifecycle
  (start [component]
    (println ";; Starting endpoint")
    (if (:routes [component])
      component
      (assoc component :routes (build-routes component))))
  
  (stop [component]
    (println ";; Stopping endpoint")
    (dissoc component :routes)))

(defn new-endpoint
  [build-routes]
  (->Endpoint build-routes))
