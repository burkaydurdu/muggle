(ns muggle.util
  (:require
    [ajax.core :as ajax]))

(def api-url "https://www.potterapi.com/v1/")
(def api-key "$2a$10$/wSQHx3YG0.R8KaR1waNAe0teh1gawP6SOMunIFMcDDsF0y//MoxK")

(defn create-request-map
  []
  {
   :params          {:key api-key}
   :format          (ajax/json-request-format)
   :response-format :json
   :keywords?       true})

(defn get-image [name]
  (cond
    (= name "Gryffindor") "/images/grif.png"
    (= name "Ravenclaw") "/images/rav.png"
    (= name "Slytherin") "/images/sly.png"
    (= name "Hufflepuff") "/images/huf.png"))