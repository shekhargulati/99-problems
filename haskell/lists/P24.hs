import P22
import P23
-- (*) Lotto: Draw N different random numbers from the set 1..M

import System.Random

randomSelect_lotto :: Int -> (Int, Int) -> IO [Int]
randomSelect_lotto n (start, end)  = sequence (randomSelect (range start end) n)
