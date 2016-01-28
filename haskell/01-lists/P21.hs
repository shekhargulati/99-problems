-- (*) Insert an element at a given position into a list

insertAt :: [a] -> Int -> a -> [a]
insertAt list pos a = let (first, second) = splitAt (pos - 1) list
                      in (first ++ [a]) ++ second
