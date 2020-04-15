(ns proto-fail.core
  #?(:clj (:require [net.cgrand.macrovich :as macros])
     :cljs (:require-macros [net.cgrand.macrovich :as macros]
                            [proto-fail.core :refer [defprotom]])))

#?(:clj
   (defmacro defprotom [proto-name fn-name fn-args]
     `(defprotocol ~proto-name
       ~(clojure.core/list fn-name fn-args))))
