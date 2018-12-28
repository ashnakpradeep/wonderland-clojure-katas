(ns card-game-war.game)
;; feel free to use these cards or use your own data structure
(def suits [:spade :club :diamond :heart])
(def ranks [2 3 4 5 6 7 8 9 10 :jack :queen :king :ace])
(def cards
  (for [suit suits
        rank ranks]
    [suit rank]))
(def p1c (shuffle cards))
  (def player1 (take 26 p1c))
  (def player2 (take-last 26 p1c))
  
(defn play-game3 [player1 player2]
	(let [ f1 (first player1)
	  f2 (first player2)
	  rf1 (.indexOf suits f1)
	  rf2 (.indexOf suits f2)
    r1 (.indexOf ranks (second player1))
    r2 (.indexOf ranks (second player2))
    rk1 (+ (* 10 rf1) r1)
    rk2(+ (* 10 rf2) r2)]
      (if (> rk1 rk2)
       (def cc (concat [player1] [player2]))
        (def cc (concat [player2] [player1])))
      cc
))

(defn play-game [player1 player2]
(while (and (not-empty player1) (not-empty player2))
(let [ f1 (first player1)
 f2 (first player2)
 rf1 (.indexOf suits (first f1))
 rf2 (.indexOf suits (first f2))
   r1 (.indexOf ranks (second f1))
     r2 (.indexOf ranks (second f2))
     rk1 (+ (* 10 rf1) r1)
       rk2(+ (* 10 rf2) r2)]
      (if (> rk1 rk2)
        (do
        (def player1 (concat (rest player1) [(first player1)]))
        (def player1 (concat player1 [f2]))
        (def player2 (rest player2)))
        
        (do
          (def player2 (concat (rest player2) [(first player2)]))
          (def player2 (concat  player2 [f1]))
          (def player1 (rest player1)))
        ))(cond (empty? player1)"player2 won"
                (empty? player2)"player1 won")
))

