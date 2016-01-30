import P35
-- (**) A list of Goldbach compositions.

goldbach_list :: [Int] -> [(Int, [Int])]
goldbach_list range = map (\even -> (even, (goldbach even))) (filter (\even -> even > 2) (filter (\n -> n `mod` 2 == 0) range))


goldbach_list1 :: Int -> [Int] -> [(Int, [Int])]
goldbach_list1 number range = filter (\t -> (((!!) (snd t) 0) > number) && (((!!) (snd t) 1) > number))(goldbach_list range)
