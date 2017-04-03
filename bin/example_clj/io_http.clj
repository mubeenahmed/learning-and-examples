(ns example-clj.io-http)


;; fire and forget, returns immediately [1], return promise is ignored
(http/get "https://domain.com/api")

(def option {:timeout 200
             :basic-auth ["user" "pass"]
             :query-params {:param1 "value" :param2 "value"}
             :headers {"X-Header" "Value"}
             })

(http/get "https://domain.com/api" option
          (fn [{:keys [status headers body errors]}]
            (if error
              (println "Failed " error)
              (println "OK" status ))))