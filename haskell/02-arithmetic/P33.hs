import P32
-- (**) Determine the prime factors of a given positive integer (2).

primeFactorsMult :: Int -> [(Int, Int)]
primeFactorsMult number = encode (primeFactors number)
