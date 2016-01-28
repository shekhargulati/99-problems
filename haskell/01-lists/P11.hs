import P09

-- (*) Modified run-length encoding
encode_modified :: Eq a => [a] -> [Either a (Int,a)]
encode_modified xs = map (\ll -> tupleOrElement ll) (pack xs)

tupleOrElement :: [a] -> Either a (Int,a)
tupleOrElement (x:[]) = Left x
tupleOrElement ll = Right (length ll, head ll)

-- Another implementation using custom data type
data ElementOrTuple a = Elem a | Tuple Int a deriving (Eq, Show)
encode_modified' :: Eq a => [a] -> [ElementOrTuple a]
encode_modified' list = map (\ll -> _encode_helper ll) (pack list)

_encode_helper :: [a] -> ElementOrTuple a
_encode_helper (x:[]) = Elem x
_encode_helper ll = Tuple (length ll) (head ll)
