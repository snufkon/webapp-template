(ns leiningen.new.webapp
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "webapp"))

(defn webapp
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' webapp project.")
    (->files data
             ;; project
             ["project.clj" (render "project.clj" data)]

             ;; resources
             ["resources/public/index.html" (render "index.html" data)]



             ;;;
             ;;; src
             ;;;
             
             ;; clj
             ["src/clj/{{sanitized}}/core.clj" (render "src/clj/core.clj" data)]

             ;; cljs
             ["src/cljs/{{sanitized}}/core.cljs" (render "src/cljs/core.cljs" data)]

             ;; scss
             ["src/scss/style.scss" (render "src/scss/style.scss" data)]
             ["src/scss/normalize.scss" (render "src/scss/normalize.scss" data)])))
