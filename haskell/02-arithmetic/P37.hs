-- (**) Determine the greatest common divisor of two positive integer numbers.

gcd' :: Int -> Int -> Int
gcd' a 0 = a
gcd' 0 b = b
gcd' a b | a > b = gcd' (a-b) b
gcd' a b = gcd' a (b-a)
