(ns muggle.home.views
  (:require [reagent.core :as reagent]
            [muggle.home.subs]
            [ajax.core :refer [GET]]
            [re-frame.core :refer [dispatch subscribe]]
            [muggle.util :refer [create-request-map api-url get-image]]))

(defn get-sorting []
  (let [m {:handler       (fn [r] (dispatch [:sorting-change r]))
           :error-handler (fn [e] (prn e))}]
    (GET (str api-url "sortingHat") (merge (create-request-map) m))))

(defn home []
  (reagent/create-class
    {:component-did-mount #()
     :reagent-render      (fn []
                            [:div.columns {:class ["centerall" "is-variable" "is-1-mobile"
                                                   "is-0-tablet" "is-3-desktop"
                                                   "is-8-widescreen" "is-2-fullhd"
                                                   "is-multiline"]}
                             [:div.column
                              [:div.card
                               [:div.card-image
                                [:figure.image.is-4by3
                                 [:a {:on-click #(get-sorting)}
                                  [:img {:src (if-let [so @(subscribe [:sorting-value])]
                                                (str (get-image so))
                                                (str "/images/sorting-hat.png"))}]]]]
                               [:div.card-content
                                [:div.content
                                 [:h3.title (if-let [so @(subscribe [:sorting-value])]
                                              (str so)
                                              (str "Sorting Hat"))]]]]]
                             [:div.column
                              [:div.card
                               [:div.card-image
                                [:figure.image.is-4by3
                                 [:a {:href "/#/houses"}
                                  [:img {:src "/images/houses.png"}]]]]
                               [:div.card-content
                                [:div.content
                                 [:h3.title "Houses"]]]]]

                             [:div.column
                              [:div.card
                               [:div.card-image
                                [:figure.image.is-4by3
                                 [:a {:href "/#/characters"}
                                  [:img {:src "/images/hogwarts.png"}]]]]
                               [:div.card-content
                                [:div.content
                                 [:h3.title "Characters"]]]]]

                             [:div.column
                              [:div.card
                               [:div.card-image
                                [:figure.image.is-4by3
                                 [:a {:href "/#/spells"}
                                  [:img {:src "/images/spell.png"}]]]]
                               [:div.card-content
                                [:div.content
                                 [:h3.title "Spells"]]]]]])}))