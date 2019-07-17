(ns tic-tac-cljs.main
  (:require [reagent.core :as r]
            [tic-tac-cljs.view.game :refer [game]]))

(defn main
  []
  (r/render [game]
            (.getElementById js/document "app")))