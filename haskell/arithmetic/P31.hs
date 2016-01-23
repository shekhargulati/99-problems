module P31 where
-- (**) Determine whether a given integer number is prime.

isPrime :: Int -> Bool
isPrime number | number < 2 = error "number should b greater than 2"
isPrime number = not (any (\n -> number `mod` n == 0) [2..(number `div` 2)])
