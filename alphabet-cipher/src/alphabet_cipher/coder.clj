(ns alphabet-cipher.coder
(use [clojure.string :only [index-of]]))

(def a(into (sorted-map) (for [x (range 97 123)
:let [y (char x)]
:when (> x 0)]
(hash-map (keyword(str y)) (- x 96)) )))

(defn encode [keyword1 message] 
 
(def abc "abcdefghijklmnopqrstuvwxyz")
  
  (def rf "")
  
  (if (= (count message) (count keyword1))
    (do
        (loop [i 0 j 1]
         (if (>= (count keyword1) j) 
         (let [
               m (subs message i j)
                s (subs keyword1 i j)
                 aa (get a (keyword s))
                 bb (get a (keyword m))
                 ss (subs abc (- bb 1) 26)
                dd (subs abc  0 (- bb 1))
                 ee (str ss dd)]
              (def rf (str rf (get ee ( - aa 1))))
              (recur (inc i) (inc j)))
                  )      
        )rf
     )

   (let [ r (mod (count message) (count keyword1))
    c (quot (count message) (count keyword1))
    f(reduce str(repeat c keyword1 ))
   v (reduce str (subs keyword1 0 r))
   x(reduce str(str f v))]
 
     (loop [i 0 j 1]
     (if (>= (count x) j) 
     (let [
           m (subs message i j)
            s (subs x i j)
             aa (get a (keyword s))
             bb (get a (keyword m))
             ss (subs abc (- bb 1) 26)
            dd (subs abc  0 (- bb 1))
             ee (str ss dd)]
              (def rf (str rf (get ee ( - aa 1))))
           (recur (inc i) (inc j))))
    

 )rf)))

(defn decode [keyword1 message]
  
  ;(def x "")
    
  (def decde (into (sorted-map) (for [x (range 97 123)
:let [y (char x)]
:when (> x 0)]
(hash-map (keyword (str(- x 96))) y) )))
    
    (let [ r (mod (count message) (count keyword1))
    c (quot (count message) (count keyword1))
    f(reduce str(repeat c keyword1 ))
   v (reduce str (subs keyword1 0 r))
   key1 (reduce str(str f v))]

    (def dr "")
 (loop [i 0 j 1]
  (if (>= (count key1) j) 
   (let [c1 (subs message i j)
         s (subs key1 i j)
          ca (get a (keyword s))
          cb (get a (keyword c))
         cs (subs abc (- ca 1) 26)
          cd (subs abc  0 (- ca 1))
          ce (str cs cd)
         
           indx (index-of ce c1)
           ]
     
   (def dr (str dr (get decde (keyword (str (+ 1 indx))))))
       
          (recur (inc i) (inc j))
          )))
)(def dddd dr)dddd

    )
          
    
    
 
(defn decipher [ciphertext message]
   
(def rrf "")
 (loop [i 0 j 1]
 (if (>= (count message) j) 
 (let [
         m (subs message i j)
         s (subs ciphertext i j)
         aa (get a (keyword s))
         bb (get a (keyword m))
         ss (subs abc (- bb 1) 26)
         dd (subs abc  0 (- bb 1))
         ee (str ss dd)
         indx (index-of ee s)]
     (def rrf (str rrf (get decde (keyword (str (+ 1 indx))))))
     (recur (inc i) (inc j)))
 )      
 )

(def rf rrf)

    (loop [i 1 j 2]
      (if (<= j (count rf))
        (let [  
              f (subs rf 0 i)
              s (subs rf i j)]
              (if (= f s) 
                 (let [ 
                        c (count rf) 
                        d j
                        r (- c d)]
                        (if (> r j)
                          (recur (+ i 1) (+ j 2))
                          (let [
                                 q (subs rf 0 r)
                                 e (subs rf j c)]
                                 (if (= q e)
;                                   
                                   (def ff f)
                                   (def ff rf)
                                  )
                                 )
                          )
                        )
         
                       (recur (+ i 1) (+ j 2))
                   )
              )))
  ff )
        
   

   


