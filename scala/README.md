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

### [P07](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P07.scala) **(\*\*) Flatten a nested list structure**


```scala
it("should return empty list when flatten an empty list") {
  val flatten: List[Any] = P07.flatten(List())
  flatten shouldBe List()
}

it("should flatten nested lists") {
  val flatten: List[Any] = P07.flatten(List("a", List("b", List("c", "d")), "e"))
  flatten should have size 5
  flatten should be(List("a", "b", "c", "d", "e"))
}

it("should flatten deep nested lists") {
  val flatten: List[Any] = P07.flatten(List("a", List("b", List("c", List("d", List("e", List("f", "g"))))), "h"))
  flatten should have size 8
  flatten should be(List("a", "b", "c", "d", "e", "f", "g", "h"))
}
```

### [P08](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P08.scala) **(\*\*) Eliminate consecutive duplicates of list elements**

If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

```scala
it("should remove consecutive duplicates in a list") {
  val compressedList: List[String] = P08.compress(List("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"))
  compressedList should have size 5
  compressedList should be(List("a", "b", "c", "d", "e"))
}

it("should not remove non consecutive duplicates in a list") {
  val compressedList: List[String] = P08.compress(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
  compressedList should have size 6
  compressedList should be(List("a", "b", "c", "a", "d", "e"))
}
```

### [P09](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P09.scala) **(\*\*) Pack consecutive duplicates of list elements into sublists**

If a list contains repeated elements they should be placed in separate sublists.

```scala
it("should pack unique elements in their own list") {
  val list = List("a", "b", "c")
  val packedList: List[List[String]] = P09.pack(list)
  packedList should have size 3
  packedList(0) should equal(List("a"))
  packedList(1) should equal(List("b"))
  packedList(2) should equal(List("c"))
}

it("should pack only consecutive duplicates in their own list") {
  val list = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
  val packedList: List[List[String]] = P09.pack(list)
  packedList should have size 6
  packedList(0) should equal(List("a", "a", "a", "a"))
  packedList(1) should equal(List("b"))
  packedList(2) should equal(List("c", "c"))
  packedList(3) should equal(List("a", "a"))
  packedList(4) should equal(List("d"))
  packedList(5) should equal(List("e", "e", "e", "e"))
}
```

### [P10](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P10.scala) **(*) Run-length encoding of a list**

Use the result of problem 1.09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as terms [N,E] where N is the number of duplicates of the element E.

```scala
it("should encode consecutive duplicate elements") {
  val list = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
  val encodedList: List[(Int, String)] = P10.encode(list)
  encodedList should have size 6
  encodedList(0) should equal((4, "a"))
  encodedList(1) should equal((1, "b"))
  encodedList(2) should equal((2, "c"))
  encodedList(3) should equal((2, "a"))
  encodedList(4) should equal((1, "d"))
  encodedList(5) should equal((4, "e"))
}
```

### [P11](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P11.scala) **(*) Modified run-length encoding**

Modify the result of problem 1.10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as [N,E] terms.

```scala
it("should apply modified run-length on list") {
  val encodedList: List[Any] = P11.encode_modified(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
  encodedList should have size 6
  encodedList(0) should equal((4, "a"))
  encodedList(1) should equal("b")
  encodedList(2) should equal((2, "c"))
  encodedList(3) should equal((2, "a"))
  encodedList(4) should equal("d")
  encodedList(5) should equal((4, "e"))
}
```

### [P12](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/lists/P12.scala) ** (\*\*) Decode a run-length encoded list**

Given a run-length code list generated as specified in problem 1.11. Construct its uncompressed version.

```scala
it("should decode an run-length encoded list") {
  val decoded: List[String] = P12.decode(List((4, "a"), "b", (2, "c"), (2, "a"), "d", (4, "e")))
  decoded should have length 14
  decoded should equal(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
}
```
