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

(defn check-box
  {:test (fn []
           (is (= (check-box {:board ["..."
                                      "..."
                                      "..."]
                              :current-player "X"}
                             {:row 0
                              :column 1
                              :player "X"})
                  {:board [".X."
                           "..."
                           "..."]
                   :current-player "X"}))
           (is (not= (check-box {:board ["..."
                                         "..."
                                         "..."]
                                 :current-player "X"}
                                {:row 0
                                 :column 1
                                 :player "X"})
                     {:board [".O."
                              "X.."
                              "..."]
                      :current-player "X"})))}
  [state {:keys [row column player]}]
  (merge state
         {:board (map-indexed #(if (= %1 row)
                                 (apply str
                                        (assoc (vec %2)
                                               column
                                               player))
                                 %2)
                              (:board state))}))

(defn toggle-player
  [state player]
  (merge state
         {:current-player player}))

(defn handle-box-selection
  [state options]
  (-> (check-box state options)
      (toggle-player (if (= (:current-player state)
                            "X")
                       "O"
                       "X"))))