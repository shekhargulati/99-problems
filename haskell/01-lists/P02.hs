-- Using built-in functions
secondLast :: [a] -> a
secondLast [] = error "Can't find secondLast element from a list with less than 2 elements"
secondLast [x] = error "Can't find secondLast element from a list with less than 2 elements"
secondLast list = last (init list)

-- Using recursion
secondLastRecursion :: [a] -> a
secondLastRecursion [] = error "Can't find secondLast element from a list with less than 2 elements"
secondLastRecursion [x] = error "Can't find secondLast element from a list with less than 2 elements"
secondLastRecursion (x:(y:[])) = x
secondLastRecursion (x:xs) = secondLastRecursion xs
