(ns user
  (:require [clojure.tools.namespace.repl :refer [refresh set-refresh-dirs]]
            [clojure.pprint :refer [pprint]]
            [reloaded.repl :refer [system init start stop go reset]]
            [{{name}}.component.system :refer [new-system]]))

(set-refresh-dirs "./src" "./dev_src")

(def ^:private config {:server {:port 8888}
                       :db {:user "{{name}}"
                            :password "{{name}}"
                            :port 3306
                            :db "{{name}}"}})

(reloaded.repl/set-init! #(new-system config))
