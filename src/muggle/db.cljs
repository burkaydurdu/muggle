(ns muggle.db
  (:require [re-frame.core :refer [reg-cofx]]))

(def default-db {:name "Muggle"})

(defn set-item!
  "Set `key' in browser's localStorage to `val`."
  [key val]
  (.setItem (.-localStorage js/window) key (.stringify js/JSON (clj->js val))))

(defn get-item
  "Returns value of `key' from browser's localStorage."
  [key]
  (js->clj (.parse js/JSON (.getItem (.-localStorage js/window) key)) :keywordize-keys true))

(defn remove-item!
  "Remove the browser's localStorage value for the given `key`"
  [key]
  (.removeItem (.-localStorage js/window) key))

(reg-cofx
  :current-user
  (fn [cofx _]
    (assoc cofx :current-user (get-item "current-user"))))