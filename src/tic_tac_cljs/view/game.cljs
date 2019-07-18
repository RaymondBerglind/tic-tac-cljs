(ns tic-tac-cljs.view.game
  (:require [reagent.core :refer [atom]]
            [tic-tac-cljs.core :as c]
            [tic-tac-cljs.view.board :refer [board]]))

(defn game
  [{state :state
    trigger-event :trigger-event}]
  [:div {:style {:margin "auto"
                 :max-width "400px"}}
   [board {:state (deref state)
           :board (:board (deref state))
           :trigger-event trigger-event}]])