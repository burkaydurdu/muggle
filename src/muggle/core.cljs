(ns muggle.core
  (:require
    [reagent.core :as r]
    [re-frame.core :as re-frame]
    [muggle.routes :refer [app-routes]]
    [muggle.navigation.views :as views]))


;; -------------------------
;; Initialize app

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (r/render [views/main-panel] (.getElementById js/document "app")))

(defn init! []
  (app-routes)
  (re-frame/dispatch-sync [:initialise-db])
  (mount-root))
