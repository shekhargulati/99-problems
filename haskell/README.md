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

### [P10](https://github.com/shekhargulati/99-problems/blob/master/haskell/lists/P10.hs) **(\*\*) Run-length encoding of a list**

Use the result of problem 1.09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as terms [N,E] where N is the number of duplicates of the element E.

```
Prelude> encode ["a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"]
[(4,"a"),(1,"b"),(2,"c"),(2,"a"),(1,"d"),(4,"e")]
```
