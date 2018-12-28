(ns alphabet-cipher.coder-test
  (:require [clojure.test :refer :all]
            [alphabet-cipher.coder :refer :all])
  )

(deftest test-encode
  (testing "can encode a message with a secret keyword"
     (def v  (encode "vigilance" "meetmeontuesdayeveningatseven"))
     (println v)
    (is (= "hmkbxebpxpmyllyrxiiqtoltfgzzv"
           (encode "vigilance" "meetmeontuesdayeveningatseven")))
    (is (= "egsgqwtahuiljgs"
           (encode "scones" "meetmebythetree")))))

;(deftest test-decode
;  (testing "can decode a message given an encoded message and a secret keyword"
;           (def v "")
;            (def ^:dynamic v (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv"))
;     (println v)
;    (is (= "meetmeontuesdayeveningatseven"
;           (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv")))
;    (is (= "meetmebythetree"
;           (decode "scones" "egsgqwtahuiljgs")))))
;****************************************************

(deftest test-decipher
  (testing "can extract the secret keyword given an encrypted message and the original message"
    (def v "meetmeontuesdayeveningatseven") 
      (def r (decode "vigilance" "hmkbxebpxpmyllyrxiiqtoltfgzzv"))
      (println r)
      (println v)
    (is (= v r))))



;****************************************************

;(deftest test-decipher
;  (testing "can extract the secret keyword given an encrypted message and the original message"
;    (def v "vigilance") 
;    (println v)
;      (def r "")
;      (println (decipher "opkyfipmfmwcvqoklyhxywgeecpvhelzg" "thequickbrownfoxjumpsoveralazydog"))
;      (println r)
;    (is (= v r))))
;    (is (= "scones"
 ;          (decipher "hcqxqqtqljmlzhwiivgbsapaiwcenmyu" "packmyboxwithfivedozenliquorjugs")))
;    (is (= (str "abcabcx")
;           (str (decipher "hfnlphoontutufa" "hellofromrussia"))))))


