(ns {{name}}.view.common
  (:require [hiccup.page :refer :all]))

(defn frame
  [& contents]
  (html5
   [:head
    [:meta {:charset "UTF-8"}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1, minimal-ui"}]
    [:link {:href "/css/normalize.css" :rel "stylesheet" :type "text/css"}]
    [:link {:href "/css/style.css" :rel "stylesheet" :type "text/css"}]
    [:title "{{name}}"]]
   [:body contents]))
