module P34 where
import P31

primeNumbers :: [Int] -> [Int]
primeNumbers range = filter (\number -> isPrime number) range
