import P09

-- data TupleOrElement a = Elem a | Tuple (Int, a) deriving (Eq, Show)
-- (*) Modified run-length encoding
encode_modified :: Eq a => [a] -> [Either a (Int,a)]
encode_modified xs = map (\ll -> tupleOrElement ll) (pack xs)

tupleOrElement :: [a] -> Either a (Int,a)
tupleOrElement (x:[]) = Left x
tupleOrElement ll = Right (length ll, head ll)
