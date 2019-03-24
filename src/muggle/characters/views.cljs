(ns muggle.characters.views
  (:require [reagent.core :as reagent]
            [ajax.core :refer [GET]]
            [re-frame.core :refer [dispatch subscribe]]
            [muggle.characters.subs]
            [muggle.util :refer [create-request-map api-url]]))

(defn get-characters []
  (let [m {:handler       (fn [r] (dispatch [:characters-list-change r]))
           :error-handler (fn [e] (prn e))}]
    (GET (str api-url "characters") (merge (create-request-map) m))))

(defn characters []
  (reagent/create-class
    {:component-did-mount (fn [] (get-characters))
     :reagent-render      (fn []
                            [:div.columns.is-multiline
                             (for [item @(subscribe [:characters-list])]
                               ^{:key (str (random-uuid))}
                               [:div.column.is-3.is-flex
                                [:div.card
                                 [:div.card-image
                                  [:figure.image.is-4by3
                                   [:img {:src "/images/sorting-hat.png"}]]]
                                 [:div.card-content
                                  [:div.content
                                   [:h3.title (:name item)]
                                   [:p
                                    [:strong "Role : "]
                                    [:span (:role item)]]
                                   [:p
                                    [:strong "House : "]
                                    [:span (:house item)]]
                                   [:p
                                    [:strong "School : "]
                                    [:span (:school item)]]
                                   [:p
                                    [:strong "Ministry Of Magic : "]
                                    [:span (str (:ministryOfMagic item))]]
                                   [:p
                                    [:strong "Order Of The Phoenix : "]
                                    [:span (str (:orderOfThePhoenix item))]]
                                   [:p
                                    [:strong "Dumbledore's Army : "]
                                    [:span (str (:dumbledoresArmy item))]]
                                   [:p
                                    [:strong "Death Eater : "]
                                    [:span (str (:deathEater item))]]
                                   [:p
                                    [:strong "BloodStatus : "]
                                    [:span (:bloodStatus item)]]
                                   [:p
                                    [:strong "Species : "]
                                    [:span (:species item)]]]]]])])}))