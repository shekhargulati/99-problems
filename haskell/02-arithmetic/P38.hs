module P38 where
-- (*) Determine whether two positive integer numbers are coprime.

coprime :: Int -> Int -> Bool
coprime first second = (gcd first second) == 1
