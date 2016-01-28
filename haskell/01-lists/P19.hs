-- (**) Rotate a list N places to the left

rotate :: [a] -> Int -> [a]
rotate list n
  | n < 0 = rotate list ((length list) + n)
  |otherwise = let (first, second) = splitAt n list
                in second ++ first
