(ns tic-tac-cljs.view.board
  (:require [tic-tac-cljs.view.board-row :refer [board-row]]))

(defn board
  [props]
  [:div {:style {:display "flex"
                 :flex-direction "column"
                 :justify-content "space-between"
                 :height "350px"
                 :width "350px"}}
   (map-indexed (fn
                  [idx row]
                  [board-row {:key (str "row_" idx)
                              :trigger-event (:trigger-event props)
                              :row-index idx
                              :row row}])
                (:board props))])