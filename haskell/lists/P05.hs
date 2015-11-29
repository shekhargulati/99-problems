-- built-in function
reverse' :: [a] -> [a]
reverse' list = reverse list

-- using recursion

reverseRecursive :: [a] -> [a]
reverseRecursive list = reverseRecursive' list []

reverseRecursive' [] dest = dest
reverseRecursive' (x:xs) dest = reverseRecursive' xs ([x] ++ dest)
