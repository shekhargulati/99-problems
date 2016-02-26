-- (**) Gray code.

gray :: Int -> [String]
gray 1 = ["0","1"]
gray n = (map (\s -> "0"++s) original) ++ (map (\s -> "1"++s) (reverse original))
          where original = gray (n-1)
