# Ninety-Nine Problems in Scala

This is an adaptation of the [Ninety-Nine Prolog Problems](https://sites.google.com/site/prologsite/prolog-problems) written by Werner Hett at the Berne University of Applied Sciences in Berne, Switzerland.

From the original source:

> The purpose of this problem collection is to give you the opportunity to practice your skills in logic programming. Your goal should be to find the most elegant solution of the given problems. Efficiency is important, but logical clarity is even more crucial. Some of the (easy) problems can be trivially solved using built-in predicates. However, in these cases, you learn more if you try to find your own solution.

> The problems have different levels of difficulty. Those marked with a single asterisk (\*) are easy. If you have successfully solved the preceding problems you should be able to solve them within a few (say 15) minutes. Problems marked with two asterisks (\*\*) are of intermediate difficulty. If you are a skilled Scala programmer it shouldn't take you more than 30-90 minutes to solve them. Problems marked with three asterisks (\*\*\*) are more difficult. You may need more time (i.e. a few hours or more) to find a good solution.


## Table of Contents

* [Lists](#lists)
* [Arithmetic](#arithmetic)
* [Logic and Codes](#logic-and-codes)
* [Binary Trees](#binary-trees)
* [Multiway Trees](#multiway-trees)
* [Graphs](#graphs)
* [Miscellaneous](#miscellaneous)

## Lists

In Scala, default List[T] is an immutable LinkedList with O(1) head access and O(n) access to interior elements. You can create a list of names like `val names = List("shekhar","rahul","sameer")`.

**TODO: Add more later**

> We are using scalatest library for test cases.

### [P01](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P01.scala) **(*) Find the last element of a list**

```scala
it("should find last element") {
  val last = P01.last(List("a", "b", "c", "d"))
  last should be("d")
}
```

### [P02](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P02.scala) **(*) Find the last but one element of a list**

```scala
it("should give second last element when list has more than two elements") {
  val numbers = List(1, 2, 11, 4, 5, 8, 10, 6)
  P02.secondLast(numbers) should be(10)
}
```

The method should throw exception when list is empty or has single element.

```scala
it("should throw exception when list is empty") {
  val thrown = the[NoSuchElementException] thrownBy P02.secondLast(List())
  thrown.getMessage should equal("Can't find secondLast element from a list with less than 2 elements")
}

it("should throw exception when list has one element") {
  val thrown = the[NoSuchElementException] thrownBy P02.secondLast(List(1))
  thrown.getMessage should equal("Can't find secondLast element from a list with less than 2 elements")
}
```

### [P03](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P03.scala) **(*) Find the Kth element of a list**

The first element of a list has index 0. In the example shown below, last element would be at kth position 4.

```scala
it("should be first element when k is 0") {
  P03.kth(List(1, 2, 3, 4, 5), 0) should be(1)
}

it("should be last element when k is equal to size of list minus one") {
  P03.kth(List(1, 2, 3, 4, 5), 4) should be(5)
}

it("should be (k+1)th element") {
  P03.kth(List(1, 2, 3, 4, 5), 2) should be(3)
}
```

### [P04](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P04.scala) **(*) Find the number of elements of a list**

```scala
it("should be zero when list is empty") {
  P04.length(List()) should be(0)
}

it("should be 5 when list has five elements") {
  P04.length(List(1, 2, 3, 4, 5)) should be(5)
}
```

### [P05](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P05.scala) **(*) Reverse a list**

```scala
it("should reverse a list") {
  P05.reverse(List(1, 2, 3, 4, 5)) should equal(List(5, 4, 3, 2, 1))
}
```

### [P06](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P06.scala) **(*) Find out whether a list is a palindrome**

```scala
it("should return true when list is palindrome") {
  P06.isPalindrome(List("x", "a", "m", "a", "x")) should be(true)
}

it("should return false when list is not palindrome") {
  P06.isPalindrome(List(1, 2, 3, 4, 5)) should be(false)
}
```
