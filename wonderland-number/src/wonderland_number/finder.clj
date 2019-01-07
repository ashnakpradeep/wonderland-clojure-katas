(ns wonderland-number.finder)

(defn equaldigits [a b]
  (= (set (str a)) (set (str b))))

(defn wondernumber [x]
 (and
  (equaldigits x (* 2 x))
  (equaldigits x (* 3 x))
  (equaldigits x (* 4 x))
  (equaldigits x (* 5 x))
  (equaldigits x (* 6 x))))

(defn wonderland-number []
  
(first (filter wondernumber (range 100000 1000000))))


