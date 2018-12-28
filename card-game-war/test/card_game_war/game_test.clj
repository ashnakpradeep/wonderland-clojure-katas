(ns card-game-war.game-test
  (:require [clojure.test :refer :all]
            [card-game-war.game :refer :all]))


;; fill in  tests for your game
(deftest test-play-round
  (testing "the highest rank wins the cards in the round")
 ;(is (= 0 1)))
 (is (= (concat [[:spade 4] [:spade 2]]) (play-game3 [:spade 4] [:spade 2])))
(is (= (concat [[:spade 4] [:spade 2]]) (play-game3 [:spade 2] [:spade 4])))
  (testing "queens are higher rank than jacks")
  (is (=  (concat [[:spade :queen] [:spade :jack]]) (play-game3 [:spade :jack] [:spade :queen])))
  (testing "kings are higher rank than queens")
  (is (=  (concat [[:club :king] [:club :queen]]) (play-game3 [:club :queen] [:club :king])))
  (testing "aces are higher rank than kings")
  (is (=  (concat [[:club :ace] [:club :king]]) (play-game3 [:club :king] [:club :ace])))
  
  
  (testing "if the ranks are equal, clubs beat spades")
  (is (=  (concat [[:club 5] [:spade 5]]) (play-game3 [:club 5] [:spade 5])))
  (testing "if the ranks are equal, diamonds beat clubs")
  (is (=  (concat [[:diamond 2] [:club 2]]) (play-game3 [:club 2] [:diamond 2])))
  (testing "if the ranks are equal, hearts beat diamonds")
  (is (=  (concat [[:heart 2] [:diamond 2]]) (play-game3 [:diamond 2] [:heart 2]))))



(deftest test-play-game
  
     (testing "winner" )
      (is (= "player1 won" (play-game  [:spade :queen] ())))
      (is (= "player2 won" (play-game () [:spade :queen])))
          )



