import P31

primeNumbers :: [Int] -> [Int]
primeNumbers range = filter (\number -> isPrime number) range
