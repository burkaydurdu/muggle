(ns muggle.home.subs
  (:require
    [re-frame.core :refer [reg-sub]]))


(reg-sub
  :sorting-value
  (fn [db _]
    (:sorting-value db)))
