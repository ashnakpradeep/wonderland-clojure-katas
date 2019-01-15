(ns fox-goose-bag-of-corn.puzzle
  (:require [clojure.set :as set]
            ))

(def start-pos [[[:fox :goose :corn :you] [:boat] []]])

(defn end-pos [last-item]
  (= last-item [#{} #{:boat} #{:fox :goose :corn :you}]))


(defn left-side-take [left-bank-state]
  (cond
    (<= (count (clojure.set/difference left-bank-state #{:you})) 1) left-bank-state
    
    (clojure.set/subset? #{:goose :fox :corn} left-bank-state) #{:goose :you}
    
    (contains? left-bank-state :goose) (clojure.set/difference left-bank-state #{:goose})
    
    :otherwise #{:you (first (clojure.set/difference left-bank-state #{:you}))}
    )
  )


(defn right-side-take [right-bank-state]
  (cond
    (<= (count (clojure.set/difference right-bank-state #{:you})) 1) #{:you}
    
    (not (contains? right-bank-state :goose)) #{:you}
    
    :otherwise #{:you :goose}
    )
  )

(defn find-next-move [last-item forward?]
  
(let [left (first last-item)
      middle (second last-item)
      right (last last-item)
      remaining (clojure.set/difference middle #{:boat})]
  (cond
    (contains? middle :you ) (if forward? {:forward false  :move [left #{:boat} (clojure.set/union right remaining)]}
                                             {:forward true :move [(clojure.set/union left remaining) #{:boat} right]})
    (contains? left :you) (let [to-take (left-side-take left)]
                            {:forward true :move [(clojure.set/difference left to-take)
                                                  (clojure.set/union middle to-take)
                                                  right]})
    :otherwise (let [to-take (right-side-take right)]
                 {:forward false :move [left
                                        (clojure.set/union middle to-take)
                                        (clojure.set/difference right to-take)]})
    )

  ) )





(defn crossing [last-item]
 
 
    (loop [out [(last-item start-pos)] forward? true]

     (if (end-pos (last-item out))
       (map vec out)
    
       (let [{forward :forward move :move} (find-next-move (last-item out) forward? )]
        
         (recur (conj out move) forward)
         )
       ))
)
(defn river-crossing-plan[]
  (let [last-item #(map set (last %))]
    (crossing last-item)))
