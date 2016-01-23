module P32 where
import P31
-- (**) Determine the prime factors of a given positive integer.

--primeFactors :: Int -> [Int]
primeFactors number = concat (filter (\xs -> (length xs) > 0) [(factors number n) | n <- [2..(quot number 2)], isPrime n])

-- factors :: Int -> Int -> [Int]
factors number f
        | number `mod` f == 0 = f : (factors (quot number f) f)
factors _ f = []
