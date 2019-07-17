(ns tic-tac-cljs.view.board-row
  (:require [tic-tac-cljs.view.box :refer [box]]))

(defn board-row
  [props]
  (let [{row :row
         trigger-event :trigger-event} props]
    [:div {:style {:display "flex"
                   :align-items "center"
                   :justify-content "space-between"}}
     (map-indexed (fn
                    [idx _]
                    [box {:key (str "box_" idx)
                          :on-click #(trigger-event {:name :box-was-selected
                                                     :data {:row row
                                                            :column idx}})}])
                  row)]))