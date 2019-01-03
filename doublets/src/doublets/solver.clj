(ns doublets.solver
  (:require [clojure.java.io :as io]
            [clojure.edn :as edn]))

(def words (-> "words.edn"
               (io/resource)
               (slurp)
               (read-string)))

(defn difference [d1 d2] (count (filter not (map = d1 d2))))

 
(defn doublereg  [dat org word1 word2]
   (def nr(filter #(== (count  word1) (count %))words))
  (if (=  word1  word2)
    (conj dat word1)
    (let [ops (->> nr
                  (filter #(not (contains? org %)))
                  (filter #(= 1 (difference  word1 %)))
                  (map #(vector % (difference  word2 %)))
                  (sort-by second)
                  (map first))
                  w1(conj dat word1)
                  w2 (conj org  word1)]
;      (if (empty? ops)
;        []
        (letfn [(f [word] (doublereg w1 w2 word  word2))]
              
(first (filter (comp not empty?) (map f ops)))))))
(defn doublets [word1 word2] (doublereg [] #{} word1 word2))
