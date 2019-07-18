(ns tic-tac-cljs.view.board-row
  (:require [tic-tac-cljs.view.box :refer [box]]
            [tic-tac-cljs.core :as c]))

(defn board-row
  [props]
  (let [{state :state
         row :row
         trigger-event :trigger-event
         row-index :row-index} props]
    [:div {:style {:display "flex"
                   :align-items "center"
                   :justify-content "space-between"}}
     (map-indexed (fn
                    [idx _]
                    [box {:key (str "box_" idx)
                          :on-click #(trigger-event {:name :box-was-selected
                                                     :data {:row row-index
                                                            :column idx}})
                          :check-mark (c/get-check-for-box state
                                                           {:row row-index 
                                                            :column idx})}])
                  row)]))