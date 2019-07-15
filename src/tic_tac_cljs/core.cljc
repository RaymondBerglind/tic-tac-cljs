(ns tic-tac-cljs.core)

(defn create-state
  []
  (array-map :board ["..."
                     "..."
                     "..."]
             :current-player "X"))

(defn is-checked-by-player
  [state {:keys [row column player]}]
  (= (-> (nth (:board state) row)
         (nth column)
         (str))
     player))

(comment
  (def state (create-state))
  (is-checked-by-player state
                        {:row 1
                         :column 2
                         :player "X"}))