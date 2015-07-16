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
             ["src/clj/{{sanitized}}/endpoint.clj" (render "src/clj/endpoint.clj" data)]
             ["src/clj/{{sanitized}}/view/index.clj" (render "src/clj/view/index.clj" data)]
             ["src/clj/{{sanitized}}/view/common.clj" (render "src/clj/view/common.clj" data)]
             
             ["src/clj/{{sanitized}}/component/system.clj" (render "src/clj/component/system.clj" data)]
             ["src/clj/{{sanitized}}/component/server.clj" (render "src/clj/component/server.clj" data)]
             ["src/clj/{{sanitized}}/component/handler.clj" (render "src/clj/component/handler.clj" data)]
             ["src/clj/{{sanitized}}/component/endpoint.clj" (render "src/clj/component/endpoint.clj" data)]
             ["src/clj/{{sanitized}}/component/database.clj" (render "src/clj/component/database.clj" data)]

             ;; cljs
             ["src/cljs/{{sanitized}}/core.cljs" (render "src/cljs/core.cljs" data)]

             ;; scss
             ["src/scss/style.scss" (render "src/scss/style.scss" data)]
             ["src/scss/normalize.scss" (render "src/scss/normalize.scss" data)]

             ;;;
             ;;; dev_src
             ;;;
             ["dev_src/user.clj" (render "dev_src/user.clj" data)]
             

             )))
