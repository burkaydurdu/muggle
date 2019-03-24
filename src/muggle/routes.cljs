(ns muggle.routes
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.history.Html5History)
  (:require [secretary.core :as secretary]
            [re-frame.core :refer [dispatch]]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [reagent.core :as reagent]
            [muggle.common.events]
            [muggle.characters.events]
            [muggle.spells.events]
            [muggle.houses.events]
            [muggle.home.events]
            [muggle.navigation.events]
            [muggle.home.views :refer [home]]
            [muggle.characters.views :refer [characters]]
            [muggle.houses.views :refer [houses]]
            [muggle.spells.views :refer [spells]]))


(defn hook-browser-navigation! []
  (doto (Html5History.)
    (events/listen
      EventType/NAVIGATE
      (fn [event]
        (secretary/dispatch! (.-token event))))
    (.setEnabled true)))


(defn app-routes []
  (secretary/set-config! :prefix "#")


  (defroute "/" []
            (dispatch [:set-active-panel [home :home]]))


  (defroute "/characters" []
            (dispatch [:set-active-panel [characters :characters]]))


  (defroute "/houses" []
            (dispatch [:set-active-panel [houses :houses]]))


  (defroute "/spells" []
            (dispatch [:set-active-panel [spells :spells]]))

  (hook-browser-navigation!))