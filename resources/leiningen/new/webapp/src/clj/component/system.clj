(ns {{name}}.component.system
  (:require [com.stuartsierra.component :as component]
            ({{name}}.component
             [server :refer [new-server]]
             [handler :refer [new-handler]]
             [endpoint :refer [new-endpoint]]
             [database :refer [new-database]])
            [{{name}}.endpoint :refer [make-endpoint]]))

(defn new-system
  [config]
  (-> (component/system-map
       :server    (new-server (:server config))
       :handler   (new-handler)
       :endpoint  (new-endpoint make-endpoint)
       :db        (new-database (:db config)))
      (component/system-using
       {:server   [:handler]
        :handler  [:endpoint]
        :endpoint [:db]})))
