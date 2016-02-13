module P33 where
import P32
import P10
import Data.Tuple
-- (**) Determine the prime factors of a given positive integer (2).

primeFactorsMult :: Int -> [(Int, Int)]
primeFactorsMult number = map (\t -> swap t) (encode (primeFactors number))
