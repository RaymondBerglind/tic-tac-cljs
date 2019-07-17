(ns tic-tac-cljs.view.box)

(defn box
  [props]
  (let [{on-click :on-click} props]
    [:div
     {:style {:border "solid"
              :border-color "345"
              :height "100px"
              :width "100px"}
      :on-click on-click}]))