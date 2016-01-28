module P10 where
import P09

-- Run-length encoding of a list
encode :: Eq a => [a] -> [(Int,a)]
encode xs = map (\ll -> (length ll, head ll)) (pack xs)
