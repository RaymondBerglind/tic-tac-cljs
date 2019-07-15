(ns tic-tac-cljs.main
  (:require [reagent.core :as r]
            [tic-tac-cljs.view.arena :refer [arena]]))

(defn main
  []
  (r/render [arena]
            (.getElementById js/document "app")))