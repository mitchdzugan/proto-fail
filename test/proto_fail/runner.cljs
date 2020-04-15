(ns proto-fail.runner
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [proto-fail.test-core]))

(doo-tests 'proto-fail.test-core)
