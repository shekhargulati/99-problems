# Ninety-Nine Problems in Haskell

This is an adaptation of the [Ninety-Nine Prolog Problems](https://sites.google.com/site/prologsite/prolog-problems) written by Werner Hett at the Berne University of Applied Sciences in Berne, Switzerland.

From the original source:

> The purpose of this problem collection is to give you the opportunity to practice your skills in logic programming. Your goal should be to find the most elegant solution of the given problems. Efficiency is important, but logical clarity is even more crucial. Some of the (easy) problems can be trivially solved using built-in predicates. However, in these cases, you learn more if you try to find your own solution.

> The problems have different levels of difficulty. Those marked with a single asterisk (\*) are easy. If you have successfully solved the preceding problems you should be able to solve them within a few (say 15) minutes. Problems marked with two asterisks (\*\*) are of intermediate difficulty. If you are a skilled Haskell programmer it shouldn't take you more than 30-90 minutes to solve them. Problems marked with three asterisks (\*\*\*) are more difficult. You may need more time (i.e. a few hours or more) to find a good solution.

## Table of Contents

* [Lists](#lists)
* [Arithmetic](#arithmetic)
* [Logic and Codes](#logic-and-codes)
* [Binary Trees](#binary-trees)
* [Multiway Trees](#multiway-trees)
* [Graphs](#graphs)
* [Miscellaneous](#miscellaneous)

## Lists

Lists are recursive type in Haskell.

### [P01](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P01.hs) **(*) Find the last element of a list**

```haskell
Prelude> last1 ["a","b","c","d"]
"d"
```

We are using `last1` because Haskell already has `last` function.

### [P02](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P02.hs) **(*) Find the last but one element of a list**

```haskell
Prelude> secondLast [1, 2, 11, 4, 5, 8, 10, 6]
10
```

When list is empty you should get exception as shown below.

```haskell
Prelude> secondLast []
*** Exception: Can't find secondLast element from a list with less than 2 elements
```

When list has one element

```haskell
Prelude> secondLast [1]
*** Exception: Can't find secondLast element from a list with less than 2 elements
```

### [P03](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P03.hs) **(*) Find the K'th element of a list**

```haskell
Prelude> kth [1,2,3,4,5] 3
4
```

### [P04](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P04.hs) **(*) Find the number of elements of a list**

```haskell
Prelude> length' [1..5]
5
```

`length'` is a valid function name in Haskell.

### [P05](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P05.hs) **(*) Reverse a list**

```haskell
Prelude> reverse' [1..5]
[5,4,3,2,1]
```
### [P06](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P06.hs) **(*) Find out whether a list is a palindrome**

```haskell
Prelude> isPalindrome ["x","a","m","a","x"]
True

Prelude> isPalindrome [1,2,3,4,5]
False
```

### [P07](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P07.hs) **(\*\*) Flatten a nested list structure**

```haskell
Prelude> flatten (List [Elem 1, List [Elem 2, List [Elem 3, Elem 4], Elem 5]])
[1,2,3,4,5]
```

### [P08](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P08.hs) **(\*\*) Eliminate consecutive duplicates of list elements**

If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed

```haskell
Prelude> compress ["a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"]
["a","b","c","a","d","e"]
```

### [P09](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P09.hs) **(\*\*) Pack consecutive duplicates of list elements into sublists**

If a list contains repeated elements they should be placed in separate sublists.

```haskell
Prelude> pack ["a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"]
[["a","a","a","a"],["b"],["c","c"],["a","a"],["d"],["e","e","e","e"]]
```

### [P10](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P10.hs) **(*) Run-length encoding of a list**

Use the result of problem 1.09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as terms [N,E] where N is the number of duplicates of the element E.

```
Prelude> encode ["a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"]
[(4,"a"),(1,"b"),(2,"c"),(2,"a"),(1,"d"),(4,"e")]
```

### [P11](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P11.hs) **(*) Modified run-length encoding**

Modify the result of problem 1.10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as [N,E] terms.

```haskell
Prelude> encode_modified ["a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"]
[Right (4,"a"),Left "b",Right (2,"c"),Right (2,"a"),Left "d",Right (4,"e")]
```

### [P12](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P12.hs) **(*) Decode a run-length encoded list**

```haskell
Prelude> decode [Right (4,"a"),Left "b",Right (2,"c"),Right (2,"a"),Left "d",Right (4,"e")]
["a","a","a","a","b","c","c","a","a","d","e","e","e","e"]
```

### [P13](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P13.hs) **(\*\*) Run-length encoding of a list (direct solution)**

Implement the so-called run-length encoding data compression method directly. i.e. don't explicitly create the sublists containing the duplicates, as in problem P09, but only count them.

```
Prelude> encode_direct ["a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"]
[(4,"a"),(1,"b"),(2,"c"),(2,"a"),(1,"d"),(4,"e")]
```

### [P14](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P14.hs) **(*) Duplicate the elements of a list**

```haskell
Prelude> duplicate ["a","b","c","d"]
["a","a","b","b","c","c","d","d"]
```
### [P15](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P15.hs) **(\*\*) Duplicate the elements of a list a given number of times**

```haskell
Prelude> duplicate ["a","b","c"] 3
["a","a","a","b","b","b","c","c","c"]
```

### [P16](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P16.hs) **(\*\*) Drop every N'th element from a list**

```haskell
Prelude> dropEveryNth ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"] 3
["a","b","d","e","g","h","j","k"]
```
### [P17](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P17.hs) **(*) Split a list into two parts; the length of the first part is given**

```haskell
Prelude> split ["a", "b", "c", "d", "e", "f", "g", "h", "i", "k"] 3
(["a","b","c"],["d","e","f","g","h","i","k"])
```

### [P18](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P18.hs) **(\*\*) Extract a slice from a list**

```haskell
Prelude> slice ["a", "b", "c", "d", "e", "f", "g", "h", "i", "k"] 3 7
["c","d","e","f"]
```

### [P19](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P19.hs) **(\*\*) Rotate a list N places to the left**

```haskell
Prelude> rotate ["a", "b", "c", "d", "e", "f", "g", "h"] 3
["d","e","f","g","h","a","b","c"]

Prelude> rotate ["a", "b", "c", "d", "e", "f", "g", "h"] (-2)
["g","h","a","b","c","d","e","f"]
```

### [P20](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P20.hs) **(*) Remove the K'th element from a list**

```haskell
Prelude> removeAt ["a", "b", "c", "d"] 2
(["a","c","d"],"b")
```

### [P21](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P21.hs) **(*) Insert an element at a given position into a list**

```haskell
Prelude> insertAt ["a", "b", "c", "d"] 2 "alfa"
["a","alfa","b","c","d"]
```

### [P22](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P22.hs) **(*) Create a list containing all integers within a given range**

```haskell
Prelude> range 4 9
[4,5,6,7,8,9]
```

### [P23](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P23.hs) **(\*\*) Extract a given number of randomly selected elements from a list**

```haskell
Prelude> randomSelect ["a", "b", "c", "d", "e", "f", "g", "h"] 3
```

### [P24](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P24.hs) **(*) Lotto: Draw N different random numbers from the set 1..M**

> Hint: Combine the solutions of problems P22 and P23

```haskell
Prelude> randomSelect_lotto 6 (1,49)
[48,2,42,42,2,8]
```

### [P25](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P25.hs) **(*) Generate a random permutation of the elements of a list**

> Hint: Use the solution of problem P23

```haskell
Prelude> randomPermutation ["a", "b", "c", "d", "e", "f"]
["b","a","b","c","a","a"]
```
