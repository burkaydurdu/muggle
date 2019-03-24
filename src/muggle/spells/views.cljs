(ns muggle.spells.views
  (:require [reagent.core :as reagent]
            [ajax.core :refer [GET]]
            [re-frame.core :refer [dispatch subscribe]]
            [muggle.spells.subs]
            [muggle.util :refer [create-request-map api-url]]))

(defn get-spells []
  (let [m {:handler       (fn [r] (dispatch [:spells-list-change r]))
           :error-handler (fn [e] (prn e))}]
    (GET (str api-url "spells") (merge (create-request-map) m))))

(defn spells []
  (reagent/create-class
    {:component-did-mount (fn [] (get-spells))
     :reagent-render      (fn []
                            [:div.columns.is-multiline
                             (for [item @(subscribe [:spells-list])]
                               ^{:key (str (random-uuid))}
                               [:div.column.is-3.is-flex
                                [:div.card
                                 [:div.card-image
                                  [:figure.image.is-4by3
                                   [:img {:src "/images/magic.png"}]]]
                                 [:div.card-content
                                  [:div.content
                                   [:h3.title (:spell item)]
                                   [:p
                                    [:strong "Type : "]
                                    [:span (:type item)]]
                                   [:p
                                    [:strong "Effect : "]
                                    [:span (:effect item)]]]]]])])}))