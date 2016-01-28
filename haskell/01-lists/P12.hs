-- (**) Decode a run-length encoded list

decode :: Eq a => [Either a (Int, a)] -> [a]
decode list = _decode list []

_decode :: Eq a => [Either a (Int, a)] -> [a] -> [a]
_decode (Left x: xs) result = _decode xs (result ++ [x])
_decode (Right (n,e): xs ) result = _decode xs (result ++ (take n (repeat e)))
_decode [] result = result
