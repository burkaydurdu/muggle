(ns muggle.spells.events
  (:require
    [re-frame.core :refer [reg-event-db]]))

(reg-event-db
  :spells-list-change
  (fn [db [_ new-list-value]]
    (assoc db :spells-list new-list-value)))
