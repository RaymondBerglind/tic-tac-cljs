(ns tic-tac-cljs.view.game
  (:require [tic-tac-cljs.core :as c]
            [tic-tac-cljs.view.board :refer [board]]))

(def state (atom (c/create-state)))

(defn trigger-event
  [event]
  (condp = (:name event)
    :box-was-selected (swap! state
                             c/handle-box-selection
                             {:row (get-in event [:data :row])
                              :column (get-in event [:data :column])
                              :player (:player (:current-player (deref state)))})))

(defn game
  []
  [:div {:style {:margin "auto"
                 :max-width "400px"}}
   [board {:board         (:board (deref state))
           :trigger-event trigger-event}]])