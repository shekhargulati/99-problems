-- using built-in function
kth :: [a] -> Int -> a
kth [] k = error "List is empty"
kth list k = list !! k

-- using recursive approach
kthRecursive :: [a] -> Int -> a
kthRecursive [] k = error "List is empty"
kthRecursive (x:xs) 0 = x
kthRecursive (x:xs) k = kthRecursive xs (k-1)
