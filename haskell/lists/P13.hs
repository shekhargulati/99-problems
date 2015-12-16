-- (**) Run-length encoding of a list (direct solution)

encode_direct :: Eq a => [a] -> [(Int, a)]
encode_direct [] = []
encode_direct (x:xs) = let (first, remaining) = span (== x) xs
                      in ((length first) + 1, x) : encode_direct remaining
