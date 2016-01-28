-- Duplicate the elements of a list

duplicate :: [a] -> [a]
duplicate list = concatMap (\x -> [x,x]) list
