import P33
-- (**) Calculate Euler's totient function phi(m) (2).

phi :: Int -> Int
phi m = product (map (\t -> ((fst t) - 1)*((fst t) ^ ((snd t) - 1))) (primeFactorsMult m))
