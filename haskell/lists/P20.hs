module P20 where
-- (*) Remove the K'th element from a list
removeAt :: [a] -> Int -> ([a],a)
removeAt list k = let (first, second) = splitAt k list
                  in ((init first) ++ second, last first)
