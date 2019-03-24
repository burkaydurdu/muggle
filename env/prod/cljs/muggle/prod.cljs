(ns muggle.prod
  (:require
    [muggle.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
