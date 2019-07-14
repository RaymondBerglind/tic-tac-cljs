(ns tic-tac-cljs.main
  (:require [reagent.core :as r]))

(defn box
  []
  [:div
   {:style {:background "#EEE"
            :height "80px"
            :width "80px"}}])

(defn app
  []
  [box])

(defn main
  []
  (r/render [app]
            (.getElementById js/document "app")))