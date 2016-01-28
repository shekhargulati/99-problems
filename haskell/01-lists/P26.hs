module P26 where
-- (**) Generate the combinations of K distinct objects chosen from the N elements of a list

import Data.List

combinations :: [a] -> Int -> [[a]]
combinations list k = filter (\l -> length l == k) (subsequences list)

combinations1 :: [a] -> Int -> [[a]]
combinations1 [] _ = []
combinations1 list 1 = map (\x -> [x]) list
combinations1 (x:xs) k = (map (\l -> (x:l)) (combinations1 xs (k-1))) ++ (combinations1 xs k)
