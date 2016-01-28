length' :: [a] -> Int
length' list = length list

lengthRecursive :: [a] -> Int
lengthRecursive [] = 0
lengthRecursive list = lengthRecursive' list 0

lengthRecursive' :: [a] -> Int -> Int
lengthRecursive' [] n = n
lengthRecursive' (x:xs) n = lengthRecursive' xs (n+1)
