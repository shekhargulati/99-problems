-- (**) Extract a slice from a list

slice :: [a] -> Int -> Int -> [a]
slice list start end = fst (splitAt (end-start) (snd (splitAt (start-1) list)))
