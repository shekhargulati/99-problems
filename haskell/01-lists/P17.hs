-- (*) Split a list into two parts; the length of the first part is given

split :: [a] -> Int -> ([a],[a])
split list n = splitAt n list
