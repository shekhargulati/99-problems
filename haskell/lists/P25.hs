import P23
-- (*) Generate a random permutation of the elements of a list

import System.Random

randomPermutation list = sequence (randomSelect list (length list))
