(ns magic-square.puzzle)
(def values [1.0 1.5 2.0 2.5 3.0 3.5 4.0 4.5 5.0])

(defn magic-square [values]
 (let[  sumvalue (reduce + values)
          magicno (/ sumvalue 3)
            me (int (/ (count values) 2))
            mm (get values me)
            mf (get values (+ me 3))
            mb (get values (- me 3))
            mr (get values (+ me 1))
            mc (get values (- me 1))]
           (def  result [[mr (- magicno (+ mr mf)) mf]
                 [(- magicno (+ mr mb))  mm (- magicno (+ mc mf))]
                 [mb (- magicno (+ mc mb)) mc]])
  )result)
         
   
   