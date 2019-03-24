(ns muggle.characters.events
  (:require
    [re-frame.core :refer [reg-event-db]]))

(reg-event-db
  :characters-list-change
  (fn [db [_ new-list-value]]
    (assoc db :characters-list new-list-value)))