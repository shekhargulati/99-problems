module P23 where
import P20

-- (**) Extract a given number of randomly selected elements from a list

import System.Random (randomRIO)

pick :: [a] -> IO a
pick xs = randomRIO (0, length xs - 1) >>= return . (xs !!)

randomSelect :: [a] -> Int -> [IO a]
randomSelect xs 0 = []
randomSelect xs n = [pick xs] ++ (randomSelect xs (n-1))
