(ns tic-tac-cljs.core
  (:require [clojure.test :refer [is]]))

(defn create-state
  []
  (array-map :board ["..."
                     "..."
                     "..."]
             :current-player "X"))

(defn is-checked-by-player
  {:test (fn []
           (is (false? (is-checked-by-player {:board ["..."
                                                      "..."
                                                      "..."]
                                              :current-player "X"}
                                             {:row 1
                                              :column 2
                                              :player "X"})))
           (is (true? (is-checked-by-player {:board ["..."
                                                     "..X"
                                                     "..."]
                                             :current-player "X"}
                                            {:row 1
                                             :column 2
                                             :player "X"})))
           (is (false? (is-checked-by-player {:board ["..."
                                                     "..O"
                                                     "..."]
                                             :current-player "X"}
                                            {:row 1
                                             :column 2
                                             :player "X"}))))}
  [state {:keys [row column player]}]
  (= (-> (nth (:board state) row)
         (nth column)
         (str))
     player))

(defn check
  [state {:keys [row column player]}]
  ;; TODO
  ())