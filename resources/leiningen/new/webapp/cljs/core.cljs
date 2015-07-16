(ns ^:figwheel-always {{name}}.core
    (:require [om.core :as om :include-macros true]
              [om-tools.core :refer-macros [defcomponent]]
              [sablono.core :as html :refer-macros [html]]))

(enable-console-print!)

(defonce app-state (atom {:text "Hello world!"}))

(defcomponent application [app owner]
  (render [_]
    (html [:div#container (:text app)])))

(om/root application
  app-state
  {:target (js/document.getElementById "app")})

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
