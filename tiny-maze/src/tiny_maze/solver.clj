(ns tiny-maze.solver)

(def maze [[:S 0 0 1]
          [1  1 0 0]
          [1  0  0 1]
          [1  1  0 :E]])

(defn positions [maze v]
  (first (for [[row-idx rowval] (map-indexed vector maze)
               [col-idx colval] (map-indexed vector rowval)
               :when (= colval v)]
           [row-idx col-idx])))

(defn neighbours [maze [row col]]
  (->> (list [(inc row) col] [(dec row) col] [row (inc col)] [row (dec col)])
       (filter #(or (= 0 (get-in maze %)) (= :E (get-in maze %))))))

(defn solving [maze points]
  (if-let [p (first points)]

    (let [sidepoints (neighbours maze p)]
      (solving (reduce #(assoc-in %1 %2 p) maze sidepoints) (concat (next points) sidepoints)))
    maze))


(defn calculation [maze]
  (let [starts  [(positions maze :S)]
        solved (solving maze starts)
        ends (positions maze :E)
        ]
     (reduce #(assoc-in %1 %2 :x) maze (take-while vector? (iterate #(get-in solved %) ends)))))

(defn solve-maze [maze]
  (calculation maze))
  