(ns muggle.houses.subs
  (:require
    [re-frame.core :refer [reg-sub]]))

(reg-sub
  :houses-list
  (fn [db _]
    (:houses-list db)))
