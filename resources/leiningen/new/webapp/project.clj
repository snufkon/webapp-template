(defproject {{ name }} "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [;; Clojure
                 [org.clojure/clojure "1.7.0"]
                 [compojure "1.3.4"]
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.3.2"]
                 [ring/ring-defaults "0.1.5"]
                 [ring-middleware-format "0.5.0"]
                 [hiccup "1.0.5"]
                 [mysql/mysql-connector-java "5.1.35"]
                 [yesql "0.4.2"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.apache.logging.log4j/log4j-slf4j-impl "2.3"]
                 [org.apache.logging.log4j/log4j-core "2.3"]
                 [com.stuartsierra/component "0.2.3"]
                 [environ "1.0.0"]
                 [meta-merge "0.1.1"]

                 ;; ClojureScript
                 [org.clojure/clojurescript "0.0-3297"]
                 [org.omcljs/om "0.8.8"]
                 [prismatic/om-tools "0.3.11"]
                 [sablono "0.3.4"]
                 [cljs-ajax "0.3.13"]
                 [com.andrewmcveigh/cljs-time "0.3.6"]

                 ;; Clojure & ClojureScript
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-figwheel "0.3.7"]
            [lein-midje "3.1.3"]
            [lein-sassy "1.0.7"]]

  :source-paths ["src/clj" "src/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src"]

              :figwheel { :on-jsload "{{name}}.core/on-js-reload" }

              :compiler {:main {{name}}.core
                         :asset-path "js/compiled/out"
                         :output-to "resources/public/js/compiled/{{sanitized}}.js"
                         :output-dir "resources/public/js/compiled/out"
                         :source-map-timestamp true }}
             {:id "min"
              :source-paths ["src"]
              :compiler {:output-to "resources/public/js/compiled/{{sanitized}}.js"
                         :main {{name}}.core
                         :optimizations :advanced
                         :pretty-print false}}]}

  :figwheel {
             ;; :http-server-root "public" ;; default and assumes "resources" 
             :server-port 3800
             ;; :server-ip "127.0.0.1" 

             :css-dirs ["resources/public/css"] ;; watch and update CSS

             ;; Start an nREPL server into the running figwheel process
             ;; :nrepl-port 7888

             ;; Server Ring Handler (optional)
             ;; if you want to embed a ring handler into the figwheel http-kit
             ;; server, this is for simple ring servers, if this
             ;; doesn't work for you just run your own server :)
             ;; :ring-handler hello_world.server/handler

             ;; To be able to open files in your editor from the heads up display
             ;; you will need to put a script on your path.
             ;; that script will have to take a file path and a line number
             ;; ie. in  ~/bin/myfile-opener
             ;; #! /bin/sh
             ;; emacsclient -n +$2 $1
             ;;
             ;; :open-file-command "myfile-opener"

             ;; if you want to disable the REPL
             ;; :repl false

             ;; to configure a different figwheel logfile path
             ;; :server-logfile "tmp/logs/figwheel-logfile.log" 
             }
  :sass {:src "src/scss"
         :dst "resources/public/css"
         :style :compressed})
