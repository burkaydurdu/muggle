(ns muggle.home.events
  (:require
    [re-frame.core :refer [reg-event-db]]))


(reg-event-db
  :sorting-change
  (fn [db [_ new-sorting-value]]
    (assoc db :sorting-value new-sorting-value)))