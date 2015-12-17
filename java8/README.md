# Ninety-Nine Problems in Java 8

This is an adaptation of the [Ninety-Nine Prolog Problems](https://sites.google.com/site/prologsite/prolog-problems) written by Werner Hett at the Berne University of Applied Sciences in Berne, Switzerland.

From the original source:

> The purpose of this problem collection is to give you the opportunity to practice your skills in logic programming. Your goal should be to find the most elegant solution of the given problems. Efficiency is important, but logical clarity is even more crucial. Some of the (easy) problems can be trivially solved using built-in predicates. However, in these cases, you learn more if you try to find your own solution.

> The problems have different levels of difficulty. Those marked with a single asterisk (\*) are easy. If you have successfully solved the preceding problems you should be able to solve them within a few (say 15) minutes. Problems marked with two asterisks (\*\*) are of intermediate difficulty. If you are a skilled Java programmer it shouldn't take you more than 30-90 minutes to solve them. Problems marked with three asterisks (\*\*\*) are more difficult. You may need more time (i.e. a few hours or more) to find a good solution.

I will use Java 8 features wherever it makes sense so that developers can learn how to use new features introduced in Java 8. If you are new to Java 8 then you can learn more about it by following my in-depth [Java 8 tutorial](https://github.com/shekhargulati/java8-the-missing-tutorial).

## Table of Contents

* [Lists](#lists)
* [Arithmetic](#arithmetic)
* [Logic and Codes](#logic-and-codes)
* [Binary Trees](#binary-trees)
* [Multiway Trees](#multiway-trees)
* [Graphs](#graphs)
* [Miscellaneous](#miscellaneous)

## Lists

In Java, lists are instances of `List<T>` sub-types. You could use `ArrayList<T>` or `LinkedList<T>`. `LinkedList` are better suited for writing functional programs because they provide you methods to get the first and last elements of a List. One of the method that you will miss when working with Java LinkedList is `tail`. `tail` gives you everything except the first element. You could easily implement `tail` as shown below.

```java
public static <T> List<T> tail(LinkedList<T> elements) {
    if (elements == null || elements.isEmpty()) {
        throw new NoSuchElementException();
    }
    if (elements.size() == 1) {
        return Collections.emptyList();
    }
    return elements.subList(1, elements.size());
}
```

> Java 8 does not support pattern matching so you have to use if-else in your code.

### [P01](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P01.java) **(*) Find the last element of a list**

```java
@Test
public void shouldFindLastElementFromAListOfAlphabets() throws Exception {
    assertThat(P01.last(asList("a", "b", "c", "d")), is(equalTo("d")));
}
```

### [P02](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P02.java) **(*) Find the last but one element of a list**

```java
@Test
public void shouldFindSecondLastElementFromAList() throws Exception {
    List<Integer> numbers = asList(1, 2, 11, 4, 5, 8, 10, 6);
    assertThat(P02.secondLast(numbers), is(equalTo(10)));
}
```

The method should throw `NoSuchElementException` when list is either empty or has one element.

```java
@Test(expected = IllegalArgumentException.class)
public void shouldThrowExceptionWhenListEmpty() throws Exception {
    P02.secondLast(Collections.emptyList());
}

@Test(expected = NoSuchElementException.class)
public void shouldThrowExceptionWhenListHasSingleElement() throws Exception {
    P02.secondLast(Arrays.asList(1));
}
```

### [P03](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P03.java) **(*) Find the Kth element of a list**

The first element of a list has index 0. In the example shown below, last element would be at kth position 4.

```java
@Test
public void shouldFindKthElementFromAList() throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    assertThat(P03.kth(numbers, 2), is(equalTo(3)));
}
```

### [P04](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P04.java) **(*) Find the number of elements of a list**

```java
@Test
public void listOfEmptyListShouldBe0() throws Exception {
    int length = P04.length(Collections.emptyList());
    assertThat(length, is(equalTo(0)));
}

@Test
public void shouldFindListOfNonEmptyList() throws Exception {
    assertThat(P04.length(Arrays.asList(1, 2, 3, 4, 5)), is(equalTo(5)));
}
```

### [P05](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P05.java) **(*) Reverse a list**

```java
@Test
public void shouldReverseAList() throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    assertThat(P05.reverse(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
}
```

### [P06](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P06.java) **(*) Find out whether a list is a palindrome**

```java
@Test
public void shouldReturnTrueWhenListIsPalindrome() throws Exception {
    assertTrue(isPalindrome(Arrays.asList("x", "a", "m", "a", "x")));
}

@Test
public void shouldReturnFalseWhenListIsNotPalindrome() throws Exception {
    assertFalse(isPalindrome(Arrays.asList(1, 2, 3, 4, 5)));
}
```

### [P07](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P07.java) **(\*\*) Flatten a nested list structure**

```java
import static java.util.Arrays.asList;

@Test
public void shouldFlattenAListOfList() throws Exception {
    List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", "d")), "e"), String.class);
    assertThat(flatten, hasSize(5));
    assertThat(flatten, hasItems("a", "b", "c", "d", "e"));
}

@Test
public void shouldFlattenDeepNestedLists() throws Exception {
    List<String> flatten = P07.flatten(asList("a", asList("b", asList("c", asList("d", "e", asList("f", "g"))), "h")), String.class);
    assertThat(flatten, hasSize(8));
    assertThat(flatten, hasItems("a", "b", "c", "d", "e", "f", "g", "h"));
}

@Test
public void shouldReturnEmptyListWhenTryingToFlattenAnEmptyList() throws Exception {
    List<String> flatten = P07.flatten(Collections.emptyList(), String.class);
    assertTrue(flatten.isEmpty());
}
```

### [P08](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P08.java) **(\*\*) Eliminate consecutive duplicates of list elements**

If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

```java
@Test
public void shouldRemoveConsecutiveDuplicatesInAList() throws Exception {
   List<String> compressedList = P08.compress(asList("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"));
   assertThat(compressedList, hasSize(5));
   assertThat(compressedList, contains("a", "b", "c","d", "e"));
}

@Test
public void shouldNotRemoveNonConsecutiveSimilarElementsFromAList() throws Exception {
   List<String> compressedList = P08.compress(asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
   assertThat(compressedList, hasSize(6));
   assertThat(compressedList, contains("a", "b", "c","a", "d", "e"));
}
```

### [P09](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P09.java) **(\*\*) Pack consecutive duplicates of list elements into sublists**

If a list contains repeated elements they should be placed in separate sublists.

```java

@Test
public void shouldReturnAListWithTwoListElementsWhenAListWithTwoUniqueElementsIsPassed() throws Exception {
    List<List<String>> packedList = P09.pack(Arrays.asList("a", "b"));
    assertThat(packedList, hasSize(2));
    assertThat(packedList.get(0), contains("a"));
    assertThat(packedList.get(1), contains("b"));
}

@Test
public void shouldPackConsecutiveDuplicatesInTheirOwnLists() throws Exception {
    List<List<String>> packedList = P09.pack(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
    assertThat(packedList, hasSize(6));
    assertThat(packedList.get(0), contains("a", "a", "a", "a"));
    assertThat(packedList.get(1), contains("b"));
    assertThat(packedList.get(2), contains("c", "c"));
    assertThat(packedList.get(3), contains("a", "a"));
    assertThat(packedList.get(4), contains("d"));
    assertThat(packedList.get(5), contains("e", "e", "e", "e"));
}
```

### [P10](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P10.java) **(*) Run-length encoding of a list**

Use the result of problem 1.09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as terms [N,E] where N is the number of duplicates of the element E.

```java
@Test
public void shouldEncodeAList() throws Exception {
    List<SimpleEntry<Integer, String>> encodedList = P10.encode(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
    assertThat(encodedList, hasSize(6));
    assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
    assertThat(encodedList.get(1), is(equalTo(new SimpleEntry<>(1, "b"))));
    assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
    assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
    assertThat(encodedList.get(4), is(equalTo(new SimpleEntry<>(1, "d"))));
    assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
}
```

### [P11](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P11.java) **(*) Modified run-length encoding**

Modify the result of problem 1.10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as [N,E] terms.

```java
@Test
public void shouldEncodeAList() throws Exception {
    List<Object> encodedList = P11.encode_modified(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
    assertThat(encodedList, hasSize(6));
    assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
    assertThat(encodedList.get(1), is(equalTo("b")));
    assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
    assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
    assertThat(encodedList.get(4), is(equalTo("d")));
    assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
}
```

### [P12](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P12.java) **(\*\*) Decode a run-length encoded list**

Given a run-length code list generated as specified in problem 1.11. Construct its uncompressed version.


```java
@Test
public void shouldDecodeEncodedList() throws Exception {
    List<String> encoded = P12.decode(
            Arrays.asList(
                    new SimpleEntry<>(4, "a"),
                    "b",
                    new SimpleEntry<>(2, "c"),
                    new SimpleEntry<>(2, "a"),
                    "d",
                    new SimpleEntry<>(4, "e")));

    assertThat(encoded, hasSize(14));
}
```

### [P13](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P13.java) **(\*\*) Run-length encoding of a list (direct solution)**

Implement the so-called run-length encoding data compression method directly. I.e. don't explicitly create the sublists containing the duplicates, as in problem P09, but only count them.

```java
@Test
public void shouldEncodeAList() throws Exception {
    List<SimpleEntry<Integer, String>> encodedList = P13.encode_direct(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"));
    assertThat(encodedList, hasSize(6));
    assertThat(encodedList.get(0), is(equalTo(new SimpleEntry<>(4, "a"))));
    assertThat(encodedList.get(1), is(equalTo(new SimpleEntry<>(1, "b"))));
    assertThat(encodedList.get(2), is(equalTo(new SimpleEntry<>(2, "c"))));
    assertThat(encodedList.get(3), is(equalTo(new SimpleEntry<>(2, "a"))));
    assertThat(encodedList.get(4), is(equalTo(new SimpleEntry<>(1, "d"))));
    assertThat(encodedList.get(5), is(equalTo(new SimpleEntry<>(4, "e"))));
}
```

### [P14](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P14.java) **(*) Duplicate the elements of a list**

```java
@Test
public void shouldDuplicateElementsInAList() throws Exception {
    List<String> duplicates = P14.duplicate(Arrays.asList("a", "b", "c", "d"));
    assertThat(duplicates, hasSize(8));
    assertThat(duplicates, contains("a", "a", "b", "b", "c", "c", "d", "d"));
}
```

### [P15](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/java8/lists/P15.java) **(\*\*) Duplicate the elements of a list a given number of times**

```java
@Test
public void shouldDuplicateElementsInAList() throws Exception {
    List<String> duplicates = P15.duplicate(Arrays.asList("a", "b", "c"), 3);
    assertThat(duplicates, hasSize(9));
    assertThat(duplicates, contains("a", "a", "a", "b", "b", "b", "c", "c", "c"));
}
```
