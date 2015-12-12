module P09 where
-- Pack consecutive duplicates of list elements into sublists.
-- If a list contains repeated elements they should be placed in separate sublists.
pack :: Eq a => [a] -> [[a]]
pack [] = []
pack (x:xs) = let (first, remaining) = span (== x) xs
              in (x:first) : pack remaining
