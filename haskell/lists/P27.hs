import P26
import Data.List
-- (**) Group the elements of a set into disjoint subsets

--  In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a predicate that generates all the possibilities via backtracking
group3 :: Eq a => [a] -> [[[a]]]
group3 xs = [[c2,c3,((xs \\ c2) \\ c3)] |c2 <- (combinations xs 2),c3 <- (combinations (xs \\ c2) 3)]

-- Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups
group' :: Eq a => [a] -> [Int] -> [[[a]]]
group' xs [] = [[]]
group' xs (n:ns) = [c:cg |c <- (combinations xs n), cg <- (group' (xs \\ c) ns)]
