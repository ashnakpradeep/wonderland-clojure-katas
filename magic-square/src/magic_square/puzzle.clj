(ns magic-square.puzzle)

(defn magic-square [values]
  [[1.0 1.5 2.0]
   [2.5 3.0 3.5]
   [4.0 4.5 5.0]]
   (def sumvalue (reduce + values))
   (def magicno (/ sumvalue 3))
   (def me (int (/ (count values) 2)))
   (let [
         mm (get values me)
         mf (get values (+ me 3))
         mb (get values (- me 3))
         mr (get values (+ me 1))
         mc (get values (- me 1))
         r1 (- magicno (+ mr mf))
         r3 (- magicno (+ mc mb))
         c1 (- magicno (+ mr mb))
         c3 (- magicno (+ mc mf))]
     (def result [[mr r1 mf]
                  [c1 mm c3]
                  [mb r3 mc]])
  )result)
         
   
   