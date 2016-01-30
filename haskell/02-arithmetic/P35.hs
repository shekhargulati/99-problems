module P35 where
import P34
-- (**) Goldbach's conjecture.
-- Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers. Example: 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case. It has been numerically confirmed up to very large numbers (much larger than we can go with our Prolog system). Write a predicate to find the two prime numbers that sum up to a given even integer.

goldbach :: Int -> [Int]
goldbach 2 = []
goldbach number = _goldbach number (primeNumbers [2..number])

_goldbach :: Int -> [Int] -> [Int]
_goldbach number (p:rp)
            | elem (number - p) (p:rp) = [p, (number - p)]
_goldbach number (p:rp) = _goldbach number rp
