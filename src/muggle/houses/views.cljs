(ns muggle.houses.views
  (:require [reagent.core :as reagent]
            [ajax.core :refer [GET]]
            [re-frame.core :refer [dispatch subscribe]]
            [muggle.houses.subs]
            [muggle.util :refer [create-request-map api-url get-image]]))

(defn get-houses []
  (let [m {:handler       (fn [r] (dispatch [:houses-list-change r]))
           :error-handler (fn [e] (prn e))}]
    (GET (str api-url "houses") (merge (create-request-map) m))))


(defn houses []
  (reagent/create-class
    {:component-did-mount (fn [] (get-houses))
     :reagent-render      (fn []
                            [:div.columns.is-multiline
                             (for [item @(subscribe [:houses-list])]
                               ^{:key (str (random-uuid))}
                               [:div.column.is-3.is-flex
                                [:div.card
                                 [:div.card-image
                                  [:figure.image.is-4by3
                                   [:img {:src (get-image (:name item))}]]]
                                 [:div.card-content
                                  [:div.content
                                   [:h3.title (:name item)]
                                   [:p
                                    [:strong "Mascot : "]
                                    [:span (:mascot item)]]
                                   [:p
                                    [:strong "Head of House : "]
                                    [:span (:headOfHouse item)]]
                                   [:p
                                    [:strong "House Ghost : "]
                                    [:span (:houseGhost item)]]
                                   [:p
                                    [:strong "Founder : "]
                                    [:span (:founder item)]]
                                   [:p
                                    [:strong "School : "]
                                    [:span (:school item)]]
                                   [:p
                                    [:strong "Values : "]
                                    [:span
                                     (for [val (:values item)]
                                       (str val " "))]]
                                   [:p
                                    [:strong "Colors : "]
                                    [:span
                                     (for [val (:colors item)]
                                       (str val " "))]]]]]])])}))
