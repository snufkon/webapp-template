(ns {{name}}.view.index
  (:require [hiccup.page :refer :all]
            [{{name}}.view.common :refer [frame]]))

(defn index
  [req]
  (frame [:header#header]
         [:div#app]
         [:script {:src "/js/compiled/{{sanitized}}.js"
                   :type "text/javascript"}]))
