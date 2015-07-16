(ns {{name}}.endpoint
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.format-params :refer [wrap-restful-params]]
            [{{name}}.view.index :as view-index]))

(def app-site-defaults
  (assoc-in site-defaults [:security :anti-forgery] false))

(defn make-endpoint
  [{:keys [db]}]
  (-> (routes
       (GET "/" req (view-index/index req))
       
       (route/resources "/")
       (route/not-found "Not Found"))
      (wrap-defaults app-site-defaults)
      (wrap-restful-params)))
