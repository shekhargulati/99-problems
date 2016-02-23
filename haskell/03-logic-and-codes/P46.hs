-- 3.01 (**) Truth tables for logical expressions.

import Text.Printf

--table :: (Bool -> Bool -> Bool) -> [String]
table fx = [(a, b, (fx a b)) | a <- [True,False], b <- [True,False]]

and' :: Bool -> Bool -> Bool
and' a b = a && b

or' :: Bool -> Bool -> Bool
or' a b = a || b
