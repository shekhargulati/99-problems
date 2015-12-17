-- (**) Duplicate the elements of a list a given number of times

duplicate :: [a] -> Int -> [a]
duplicate list n = concatMap (\x -> replicate n x) list
