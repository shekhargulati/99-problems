import P38
-- 2.09 (**) Calculate Euler's totient function phi(m).

totient_phi :: Int -> Int
totient_phi m = length (filter (\r -> (coprime r m)) [1..m])
