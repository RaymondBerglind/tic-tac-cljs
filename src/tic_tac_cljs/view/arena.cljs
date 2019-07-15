(ns tic-tac-cljs.view.arena
  (:require [tic-tac-cljs.view.box :refer [box]]
            [tic-tac-cljs.core :as c]))

(defn board-row
  [props]
  [:div {:style {:display "flex"
                 :align-items "center"
                 :justify-content "space-between"}}
   [box]
   [box]
   [box]])

(defn arena
  []
  [:div {:style {:display "flex"
                 :flex-direction "column"
                 :justify-content "space-between"
                 :height "350px"
                 :width "350px"}}
   (map-indexed (fn
                  [idx row]
                  [board-row {:key (str "row_" idx)}])
                (:board (c/create-state)))])