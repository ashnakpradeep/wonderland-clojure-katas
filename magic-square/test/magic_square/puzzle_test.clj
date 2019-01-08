(ns magic-square.puzzle-test
  (:require [clojure.test :refer :all]
            [magic-square.puzzle :refer :all]))

(defn sum-rows [m]
  (map #(reduce + %) m))

(def values [1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0])

(defn sum-cols [m]
  [(reduce + (map first m))
   (reduce + (map second m))
   (reduce + (map last m))])

(defn sum-diagonals [m]
  [(+ (get-in m [0 0]) (get-in m [1 1]) (get-in m [2 2]))
   (+ (get-in m [2 0]) (get-in m [1 1]) (get-in m [0 2]))])

(deftest test-magic-square
  (testing "all the rows, columns, and diagonal add to the same number"
    (is (=(set (sum-rows (magic-square values)))
           (set (sum-cols (magic-square values)))
           (set (sum-diagonals (magic-square values)))
           )
        )

    (is (= 1
           (count (set (sum-rows (magic-square values))))
           (count (set (sum-cols (magic-square values))))
           (count (set (sum-diagonals (magic-square values))))))
    ))
