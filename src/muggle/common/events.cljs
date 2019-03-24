(ns muggle.common.events
  (:require [re-frame.core :refer [reg-event-db reg-event-fx inject-cofx]]
            [muggle.db :as db]))

(reg-event-fx
  :initialise-db
  [(inject-cofx :current-user)]
  (fn [{:keys [_ current-user]} _]
    {:db (assoc db/default-db :current-user current-user)}))
