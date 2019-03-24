(ns muggle.characters.subs
  (:require
    [re-frame.core :refer [reg-sub]]))

(reg-sub
  :characters-list
  (fn [db _]
    (:characters-list db)))
