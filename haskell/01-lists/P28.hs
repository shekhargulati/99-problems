-- (**) Sorting a list of lists according to length of sublists
import Data.Function (on)
import Data.List (sortBy, groupBy)
import Data.Ord (comparing)

lsort :: [[a]] -> [[a]]
lsort list = sortBy compareListLength list
              where compareListLength xs1 xs2 = length xs1 `compare` length xs2

lfsort :: [[a]] -> [[a]]
lfsort list = concat groups
      where groups = lsort (groupBy byLength (lsort list))
            byLength xs1 xs2 = (length xs1) == (length xs2)
