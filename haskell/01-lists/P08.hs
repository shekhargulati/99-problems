compress :: Eq a => [a] -> [a]
compress [] = []
compress (x:xs) = x : compress (dropWhile (== x) xs)

compress' :: Eq a => [a] -> [a]
compress' list = compressR list []

compressR :: Eq a => [a] -> [a] -> [a]
compressR [] r = r
compressR (x:xs) r = compressR (dropWhile (== x) xs) (r ++ [x])
