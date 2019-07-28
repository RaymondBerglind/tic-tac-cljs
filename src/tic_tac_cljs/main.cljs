(ns tic-tac-cljs.main
  (:require [reagent.core :as r]
            [tic-tac-cljs.view.game :refer [game]]
            [tic-tac-cljs.core :as c]))

(def state (r/atom (c/create-state)))

(defn trigger-event
  [event]
  (condp = (:name event)
    :box-was-selected (swap! state
                             c/handle-box-selection
                             {:row (get-in event [:data :row])
                              :column (get-in event [:data :column])
                              :player (:current-player (deref state))})))

(defn game-loop
  [key state-atom old-state new-state]
  (.log js/console (str "Switched the state: "
                        new-state)))

(add-watch state
           :game-loop-watcher
           game-loop)

(defn main
  []
  (r/render [game {:state state
                   :trigger-event trigger-event}]
            (.getElementById js/document "app")))