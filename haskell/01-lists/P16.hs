-- (**) Drop every N'th element from a list
dropEveryNth :: [a] -> Int -> [a]
dropEveryNth list 0 = list
dropEveryNth list n = map (\x -> snd x) (filter (\x -> (fst x) `mod` 3 /= 0) (zip [1..] list))
