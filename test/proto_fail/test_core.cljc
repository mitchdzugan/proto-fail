(ns proto-fail.test-core
  (:require #?(:clj [clojure.test :refer :all]
               :cljs [cljs.test :refer-macros [is deftest testing]])
            [proto-fail.core :refer [defprotom]]))

(println (macroexpand-1 '(defprotom TestProtocol test-method [a])))
(comment
  "Result of macroexpand-1. `lein test-cljs` works
   if you replace the macro with this"
  (cljs.core/defprotocol TestProtocol (test-method [a])))

(defprotom TestProtocol test-method [a])

(extend-protocol TestProtocol
  #?(:clj String :cljs js/String)
  (test-method [_] 42))

(deftest core-api
  (testing "protocol issue")
  (is (= (test-method "") 42)))
