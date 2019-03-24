(ns muggle.spells.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
  :spells-list
  (fn [db _]
    (:spells-list db)))
