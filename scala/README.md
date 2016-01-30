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

### [P01](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P01.scala) **(*) Find the last element of a list**

```scala
it("should find last element") {
  val last = P01.last(List("a", "b", "c", "d"))
  last should be("d")
}
```

### [P02](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P02.scala) **(*) Find the last but one element of a list**

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

### [P03](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P03.scala) **(*) Find the Kth element of a list**

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

### [P04](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P04.scala) **(*) Find the number of elements of a list**

```scala
it("should be zero when list is empty") {
  P04.length(List()) should be(0)
}

it("should be 5 when list has five elements") {
  P04.length(List(1, 2, 3, 4, 5)) should be(5)
}
```

### [P05](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P05.scala) **(*) Reverse a list**

```scala
it("should reverse a list") {
  P05.reverse(List(1, 2, 3, 4, 5)) should equal(List(5, 4, 3, 2, 1))
}
```

### [P06](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P06.scala) **(*) Find out whether a list is a palindrome**

```scala
it("should return true when list is palindrome") {
  P06.isPalindrome(List("x", "a", "m", "a", "x")) should be(true)
}

it("should return false when list is not palindrome") {
  P06.isPalindrome(List(1, 2, 3, 4, 5)) should be(false)
}
```

### [P07](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P07.scala) **(\*\*) Flatten a nested list structure**


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

### [P08](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P08.scala) **(\*\*) Eliminate consecutive duplicates of list elements**

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

### [P09](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P09.scala) **(\*\*) Pack consecutive duplicates of list elements into sublists**

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

### [P10](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P10.scala) **(*) Run-length encoding of a list**

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

### [P11](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P11.scala) **(*) Modified run-length encoding**

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

### [P12](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P12.scala) **(\*\*) Decode a run-length encoded list**

Given a run-length code list generated as specified in problem 1.11. Construct its uncompressed version.

```scala
it("should decode an run-length encoded list") {
  val decoded: List[String] = P12.decode(List((4, "a"), "b", (2, "c"), (2, "a"), "d", (4, "e")))
  decoded should have length 14
  decoded should equal(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
}
```

### [P13](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P13.scala) **(\*\*) Run-length encoding of a list (direct solution)**

Implement the so-called run-length encoding data compression method directly. I.e. don't explicitly create the sublists containing the duplicates, as in problem 1.09, but only count them

```scala
it("should perform run-length encoding") {
  val encodedList: List[Any] = P13.encode_direct(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
  encodedList should have size 6
  encodedList(0) should equal((4, "a"))
  encodedList(1) should equal("b")
  encodedList(2) should equal((2, "c"))
  encodedList(3) should equal((2, "a"))
  encodedList(4) should equal("d")
  encodedList(5) should equal((4, "e"))
}
```

### [P14](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P14.scala) **(*) Duplicate the elements of a list**

```scala
it("should duplicate elements in a list") {
  val duplicateList: List[String] = P14.duplicate(List("a", "b", "c", "d"))
  duplicateList should have length 8
  duplicateList should equal(List("a", "a", "b", "b", "c", "c", "d", "d"))
}
```

### [P15](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P15.scala) **(\*\*) Duplicate the elements of a list a given number of times**

```scala
it("should duplicate N times elements of a list") {
  val duplicates: List[String] = P15.duplicateTimes(List("a", "b", "c"), 3)
  duplicates should have length 9
  duplicates should equal(List("a", "a", "a", "b", "b", "b", "c", "c", "c"))
}
```

### [P16](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P16.scala) **(\*\*) Drop every N'th element from a list**

```scala
it("should remove every third item in the list") {
  val result = P16.dropEveryNth(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3)
  result should have length 8
  result should be(List("a", "b", "d", "e", "g", "h", "j", "k"))
}

it("should return same list when list has less items than n ") {
  val result = P16.dropEveryNth(List("a", "b"), 3)
  result should have length 2
  result should be(List("a", "b"))
}

it("should return same list when n is 0") {
  val result = P16.dropEveryNth(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0)
  result should have length 11
  result should be(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"))
}
```

### [P17](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P17.scala) **(*) Split a list into two parts; the length of the first part is given**

```scala
it("should split into two halves by length") {
  val (first, second) = P17.split(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3)
  first should have length 3
  first should be(List("a", "b", "c"))
  second should have length 7
  second should be(List("d", "e", "f", "g", "h", "i", "k"))
}

it("should split into two halves by length with size 0 and list size when n is 0") {
  val (first, second) = P17.split(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 0)
  first should have length 0
  first should be(List())
  second should have length 10
  second should be(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"))
}
```

### [P18](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P18.scala) **(\*\*) Extract a slice from a list**

```scala
it("should return list between two indexes") {
  val result = P18.slice(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, 7)
  result should have length 5
  result should be(List("c", "d", "e", "f", "g"))
}
```

### [P19](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P19.scala) **(\*\*) Rotate a list N places to the left**

```scala
it("should make head last element and second element from left as head") {
  val rotated = P19.rotate(List("a", "b", "c", "d", "e", "f", "g", "h"), 1)
  rotated.head should equal("b")
  rotated.last should equal("a")
}

it("should return same list when n is 0") {
  val rotated = P19.rotate(List("a", "b", "c", "d", "e", "f", "g", "h"), 0)
  rotated should be(List("a", "b", "c", "d", "e", "f", "g", "h"))
}

it("should rotate list by three elements") {
  val rotated = P19.rotate(List("a", "b", "c", "d", "e", "f", "g", "h"), 3)
  rotated should be(List("d", "e", "f", "g", "h", "a", "b", "c"))
}

it("should rotate when n is negative") {
  val rotated = P19.rotate(List("a", "b", "c", "d", "e", "f", "g", "h"), -2)
  rotated should be(List("g", "h", "a", "b", "c", "d", "e", "f"))
}
```

### [P20](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P20.scala) **(*) Remove the K'th element from a list**

```scala
it("should remove kth element from a list") {
  val result = P20.removeAt(List("a", "b", "c", "d"), 2)
  result._1 should equal(List("a", "c", "d"))
  result._2 should equal("b")
}
```

### [P21](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P21.scala) **(*) Insert an element at a given position into a list**

```scala
it("should insert element at the second position") {
  val result = P21.insertAt(List("a", "b", "c", "d"), 2, "alfa")
  result should have length 5
  result should be(List("a", "alfa", "b", "c", "d"))
}


it("should insert element at the zeroth position") {
  val result = P21.insertAt(List("a", "b", "c", "d"), 1, "alfa")
  result should have length 5
  result should be(List("alfa", "a", "b", "c", "d"))
}

it("should insert element at the end position") {
  val result = P21.insertAt(List("a", "b", "c", "d"), 5, "alfa")
  result should have length 5
  result should be(List("a", "b", "c", "d", "alfa"))
}
```

### [P22](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P22.scala) **(*) Create a list containing all integers within a given range**

```scala
it("should give a range between 4 to 9 both inclusive") {
  val range: List[Int] = P22.range(4, 9)
  range should have length 6
  range should be(List(4, 5, 6, 7, 8, 9))
}
```

### [P23](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P23.scala) **(\*\*) Extract a given number of randomly selected elements from a list**

Hint: Use the built-in `scala.util.Random` and the result of problem P20

```scala
it("should randomly select three elements") {
  val randomElements: List[String] = P23.randomSelect(List("a", "b", "c", "d", "e", "f", "g", "h"), 3)
  randomElements should have length 3
}
```

### [P24](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P24.scala) **(*) Lotto: Draw N different random numbers from the set 1..M**

> Hint: Combine the solutions of problems P22 and P23

```scala
it("should give 6 random number between 1 and 49") {
  val randomList: List[Int] = P24.randomSelect(6, (1, 49))
  randomList should have length 6
  println(randomList) // One possible output List(18, 47, 6, 43, 48, 38)
}
```
### [P25](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P25.scala) **(*) Generate a random permutation of the elements of a list**

> Hint: Use the solution of problem P23

```scala
it("should generate random permutation of elements of a list") {
  val permutation: List[String] = P25.randomPermutation(List("a", "b", "c", "d", "e", "f"))
  permutation should have length 6
  permutation should contain theSameElementsAs  List("a", "b", "c", "d", "e", "f")
  println(permutation) // One possible output List(b, a, c, e, d, f)
}
```

### [P26](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P26.scala) **(\*\*) Generate the combinations of K distinct objects chosen from the N elements of a list**

```scala
it("should generate all combinations of size K from N elements of a list") {
  val combinations = P26.combinations(List("a", "b", "c", "d", "e", "f"), 3)
  combinations should have length 20
}
```

### [P27](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P27.scala) **(\*\*) Group the elements of a set into disjoint subsets**

This problem has two parts.

**Part 1**: In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a predicate that generates all the possibilities via backtracking.

```scala
it("should group 9 person into 3 groups of size 2,3, and 4") {
  val group = P27.group3(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"))
  group should have length 1260
}
```

**Part 2**: Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.

```scala
it("should group 9 person into 3 groups of size 2,3, and 4") {
  val group: List[List[String]] = P27.group(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"), List(2, 3, 4))
  group should have length 1260
}

it("should group 9 person into 3 groups of size 2,2, and 5") {
  val group: List[List[String]] = P27.group(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"), List(2, 2, 5))
  group should have length 756
}
```

### [P28](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_01_lists/P28.scala) **(\*\*) Sorting a list of lists according to length of sublists**

a) We suppose that a list (InList) contains elements that are lists themselves. The objective is to sort the elements of InList according to their **length**. E.g. short lists first, longer lists later, or vice versa.

```scala
it("should sort list elements by length") {
  val input = List(List("a", "b", "c"), List("d", "e"), List("f", "g", "h"), List("d", "e"), List("i", "j", "k"), List("m", "n"), List("o"))
  val result = P28.lsort(input)
  result should be(List(List("o"), List("d", "e"), List("d", "e"), List("m", "n"), List("a", "b", "c"), List("f", "g", "h"), List("i", "j", "k")))
}
```

b) Again, we suppose that a list (InList) contains elements that are lists themselves. But this time the objective is to sort the elements of InList according to their **length frequency**; i.e. in the default, where sorting is done in ascending order, lists with rare lengths are placed first, others with a more frequent length come later

```scala
it("should sort list by length frequency") {
  val input = List(List("a", "b", "c"), List("d", "e"), List("f", "g", "h"), List("d", "e"), List("i", "j", "k", "l"), List("m", "n"), List("o"))
  val result = P28.lfsort(input)
  result should be(List(List("i", "j", "k", "l"), List("o"), List("a", "b", "c"), List("f", "g", "h"), List("d", "e"), List("d", "e"), List("m", "n")))
}
```

## Arithmetic


### [P31](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_02_arithmetic/P31.scala) **(\*\*) Determine whether a given integer number is prime.**

```
it("7 is a prime number") {
  val prime = Problem31.isPrime(7)
  prime should be(true)
}

it("10 is not prime number") {
  val prime = Problem31.isPrime(10)
  prime should be(false)
}
```

### [P32](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_02_arithmetic/P32.scala) **(\*\*) Determine the prime factors of a given positive integer.**

```scala
it("[2,2,2] are prime factors of 8") {
  val fs = Problem32.primeFactors(8)
  fs should be(List(2, 2, 2))
}

it("[2,2,3] are prime factors of 12") {
  val fs = Problem32.primeFactors(12)
  fs should be(List(2, 2, 3))
}

it("[3,3,5,7] are prime factors of 315") {
  val fs = Problem32.primeFactors(315)
  fs should be(List(3, 3, 5, 7))
}

it("[3,11] are prime factors of 33"){
  val fs = Problem32.primeFactors(33)
  fs should be(List(3, 11))
}
```

### [P33](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_02_arithmetic/P33.scala) **(\*\*) Determine the prime factors of a given positive integer (2).**

```scala
it("[[3,2],[5,1],[7,1]] is prime factors multiples of 315") {
  val fs = P33.primeFactorsMult(315)
  fs should be(List((3, 2), (5, 1), (7, 1)))
}

it("[[3,1],[11,1]] is prime factors multiples of 33") {
  val fs = P33.primeFactorsMult(33)
  fs should be(List((3, 1), (11, 1)))
}
```

### [P34](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_02_arithmetic/P34.scala) **(*) A list of prime numbers.**

```scala
it("should list 2,3,5,7 as prime numbers between 0 and 10") {
  val primeNumbers = P34.primeNumbers(0 to 10)
  primeNumbers should have length 4
  primeNumbers should be(List(2, 3, 5, 7))
}

it("should list 7, 11, 13, 17, 19, 23, 29, 31 as prime numbers between 7 and 31") {
  val primeNumbers = P34.primeNumbers(7 to 31)
  primeNumbers should have length 8
  primeNumbers should be(List(7, 11, 13, 17, 19, 23, 29, 31))
}
```

### [P35](https://github.com/shekhargulati/99-problems/blob/master/scala/src/main/scala/com/shekhargulati/ninetynine_problems/scala/_02_arithmetic/P35.scala) **(\*\*)  Goldbach's conjecture.**

Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers. Example: `28 = 5 + 23`. It is one of the most famous facts in number theory that has not been proved to be correct in the general case. It has been numerically confirmed up to very large numbers. Write a predicate to find the two prime numbers that sum up to a given even integer.

```scala
it("8 is the sum of 5 and 3 prime numbers") {
  val numbers = P35.goldbach(8)
  numbers should have length 2
  numbers should be(List(3, 5))
}

it("28 is the sum of 5 and 23 prime numbers") {
  val numbers = P35.goldbach(28)
  numbers should have length 2
  numbers should be(List(5, 23))
}

}
```
