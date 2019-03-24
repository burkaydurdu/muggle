(ns muggle.houses.events
  (:require
    [re-frame.core :refer [reg-event-db]]))

(reg-event-db
  :houses-list-change
  (fn [db [_ new-list-value]]
    (assoc db :houses-list new-list-value)))
