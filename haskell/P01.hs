last1 :: [a] -> a
last1 xs = last xs

lastRecursive :: [a] -> a
lastRecursive [] = error "No last element found in empty list"
lastRecursive [x] = x
lastRecursive (x:xs) = lastRecursive xs
