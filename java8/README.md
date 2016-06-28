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

### [P01](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P01.java) **(*) Find the last element of a list**

```java
@Test
public void shouldFindLastElementFromAListOfAlphabets() throws Exception {
    assertThat(P01.last(asList("a", "b", "c", "d")), is(equalTo("d")));
}
```

### [P02](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P02.java) **(*) Find the last but one element of a list**

```java
@Test
public void shouldFindSecondLastElementFromAList() throws Exception {
    List<Integer> numbers = asList(1, 2, 11, 4, 5, 8, 10, 6);
    assertThat(P02.secondLast(numbers), is(equalTo(10)));
}
```

The method should throw `NoSuchElementException` when list is either empty or has one element.

```java
@Test(expected = NoSuchElementException.class)
public void shouldThrowExceptionWhenListEmpty() throws Exception {
    P02.secondLast(Collections.emptyList());
}

@Test(expected = NoSuchElementException.class)
public void shouldThrowExceptionWhenListHasSingleElement() throws Exception {
    P02.secondLast(Arrays.asList(1));
}
```

### [P03](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P03.java) **(*) Find the Kth element of a list**

The first element of a list has index 0. In the example shown below, last element would be at kth position 4.

```java
@Test
public void shouldFindKthElementFromAList() throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    assertThat(P03.kth(numbers, 2), is(equalTo(3)));
}
```

### [P04](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P04.java) **(*) Find the number of elements of a list**

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

### [P05](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P05.java) **(*) Reverse a list**

```java
@Test
public void shouldReverseAList() throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    assertThat(P05.reverse(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
}
```

### [P06](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P06.java) **(*) Find out whether a list is a palindrome**

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

### [P07](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P07.java) **(\*\*) Flatten a nested list structure**

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

### [P08](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P08.java) **(\*\*) Eliminate consecutive duplicates of list elements**

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

### [P09](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P09.java) **(\*\*) Pack consecutive duplicates of list elements into sublists**

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

### [P10](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P10.java) **(*) Run-length encoding of a list**

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

### [P11](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P11.java) **(*) Modified run-length encoding**

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

### [P12](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P12.java) **(\*\*) Decode a run-length encoded list**

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

### [P13](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P13.java) **(\*\*) Run-length encoding of a list (direct solution)**

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

### [P14](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P14.java) **(*) Duplicate the elements of a list**

```java
@Test
public void shouldDuplicateElementsInAList() throws Exception {
    List<String> duplicates = P14.duplicate(Arrays.asList("a", "b", "c", "d"));
    assertThat(duplicates, hasSize(8));
    assertThat(duplicates, contains("a", "a", "b", "b", "c", "c", "d", "d"));
}
```

### [P15](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P15.java) ** (\*\*) Duplicate the elements of a list a given number of times**

```java
@Test
public void shouldDuplicateElementsInAList() throws Exception {
    List<String> duplicates = P15.duplicate(Arrays.asList("a", "b", "c"), 3);
    assertThat(duplicates, hasSize(9));
    assertThat(duplicates, contains("a", "a", "a", "b", "b", "b", "c", "c", "c"));
}
```

### [P16](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P16.java) **(\*\*) Drop every N'th element from a list**

```java
@Test
public void shouldDropEveryNthElement() throws Exception {
    List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3);
    assertThat(result, hasSize(8));
    assertThat(result, contains("a", "b", "d", "e", "g", "h", "j", "k"));
}

@Test
public void shouldReturnSameListWhenNIsLessThanListSize() throws Exception {
    List<String> result = P16.dropEveryNth(Arrays.asList("a", "b"), 3);
    assertThat(result, hasSize(2));
    assertThat(result, contains("a", "b"));
}

@Test
public void shouldReturnSameListWhenNIsZero() throws Exception {
    List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0);
    assertThat(result, hasSize(11));
    assertThat(result, contains("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
}
```

### [P17](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P17.java) **(*) Split a list into two parts; the length of the first part is given**

```java
@Test
public void shouldSplitInTwoHalves() throws Exception {
    Map<Boolean, List<String>> result = P17.split(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3);
    assertThat(result.get(true), contains("a", "b", "c"));
    assertThat(result.get(false), contains("d", "e", "f", "g", "h", "i", "k"));
}
```

### [P18](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P18.java) **(\*\*) Extract a slice from a list**

```java
@Test
public void shouldGiveSliceOfAList() throws Exception {
    List<String> slice = P18.slice(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, 7);
    assertThat(slice, hasSize(5));
    assertThat(slice, contains("c", "d", "e", "f", "g"));
}
```

### [P19](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P19.java) **(\*\*) Rotate a list N places to the left**

```java
@Test
public void shouldRotateAListByThreeElementsWhenNIs3() throws Exception {
    List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
    assertThat(rotated, equalTo(Arrays.asList("d", "e", "f", "g", "h", "a", "b", "c")));
}

@Test
public void shouldReturnSameListWhenNIs0() throws Exception {
    List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 0);
    assertThat(rotated, equalTo(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h")));
}

@Test
public void shouldRotateWhenNIsNegative() throws Exception {
    List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), -2);
    assertThat(rotated, equalTo(Arrays.asList("g", "h", "a", "b", "c", "d", "e", "f")));
}
```


### [P20](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P20.java) **(*) Remove the K'th element from a list**

```java
@Test
public void shouldRemoveKthElementFromList() throws Exception {
    Object[] result = P20.removeAt(Arrays.asList("a", "b", "c", "d"), 2);
    assertThat(result[0], equalTo(Arrays.asList("a", "c", "d")));
    assertThat(result[1], equalTo("b"));
}
```

### [P21](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P21.java) **(*) Insert an element at a given position into a list**

```java
@Test
public void shouldInsertElementAtSecondPosition() throws Exception {
    List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
    List<String> result = P21.insertAt(input, 2, "alfa");
    assertThat(result, hasSize(5));
    assertThat(result, contains("a", "alfa", "b", "c", "d"));

}

@Test
public void shouldInsertElementAtFirstPosition() throws Exception {
    List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
    List<String> result = P21.insertAt(input, 1, "alfa");
    assertThat(result, hasSize(5));
    assertThat(result, contains("alfa", "a", "b", "c", "d"));

}

@Test
public void shouldInsertElementAtEnd() throws Exception {
    List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
    List<String> result = P21.insertAt(input, 5, "alfa");
    assertThat(result, hasSize(5));
    assertThat(result, contains("a", "b", "c", "d", "alfa"));
}
```

### [P22](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P22.java) **(*) Create a list containing all integers within a given range**

```java
@Test
public void shouldCreateARangeBetween4And9() throws Exception {
    List<Integer> range = P22.range(4, 9);
    assertThat(range, hasSize(6));
    assertThat(range, contains(4, 5, 6, 7, 8, 9));

}
```

### [P23](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P23.java) **(\*\*) Extract a given number of randomly selected elements from a list**

```java
@Test
public void shouldReturnAListOfThreeRandomSelectedElements() throws Exception {
    List<String> result = P23.randomSelect(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
    System.out.println(result);
    assertThat(result, hasSize(3));
}
```

### [P24](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P24.java) **(*) Lotto: Draw N different random numbers from the set 1..M**

> Hint: Combine the solutions of problems P22 and P23

```java
@Test
public void shouldGive6RandomNumbersFromARangeStartingFrom1To49() throws Exception {
    List<Integer> randomList = P24.randomSelect(6, 1, 49);
    assertThat(randomList, hasSize(6));
    System.out.println(randomList); // One possible output [47, 30, 36, 38, 11, 1]
}
```

### [P25](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P25.java) **(*) Generate a random permutation of the elements of a list**

> Hint: Use the solution of problem P23

```java
@Test
public void shouldGenerateRandomPermutationOfElementsOfAList() throws Exception {
    List<String> permutation = P25.randomPermutation(Stream.of("a", "b", "c", "d", "e", "f").collect(toList()));
    assertThat(permutation, hasSize(6));
    assertThat(permutation, containsInAnyOrder("a", "b", "c", "d", "e", "f"));
    System.out.println(permutation); // one possible output [a, e, f, c, b, d]
}
```

### [P26](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P26.java) **(\*\*) Generate the combinations of K distinct objects chosen from the N elements of a list**

```java
@Test
public void shouldFindAllCombinationsOfSize3FromAListWithSize6() throws Exception {
    List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(toList());
    List<List<String>> combinations = P26.combinations(input, 3);
    assertThat(combinations, hasSize(20));
}
```

### [P27](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P27.java) **(\*\*) Group the elements of a set into disjoint subsets**

a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a predicate that generates all the possibilities via backtracking

```java
@Test
public void shouldGroupIntoThreeGroupsOfSize_2_3_and_4() throws Exception {
    List<String> input = Stream.of("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida").collect(toList());
    List<List<List<String>>> groups = P27.group3(input);
    assertThat(groups, hasSize(1260));
}
```

b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.

```java
@Test
public void shouldGroupIntoThreeGroupsOfSize_2_2_and_5() throws Exception {
    List<String> input = Stream.of("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida").collect(toList());
    List<List<List<String>>> groups = P27.group(input, Stream.of(2, 2, 5).collect(Collectors.toList()));
    assertThat(groups, hasSize(756));
}
```

### [P28](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_01_lists/P28.java) **(\*\*) Sorting a list of lists according to length of sublists**

a) We suppose that a list (InList) contains elements that are lists themselves. The objective is to sort the elements of InList according to their **length**. E.g. short lists first, longer lists later, or vice versa.

```java
@Test
public void shouldSortByElementLength() throws Exception {
    List<List<String>> input = Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e"), Arrays.asList("f", "g", "h"), Arrays.asList("d", "e"), Arrays.asList("i", "j", "k"), Arrays.asList("m", "n"), Arrays.asList("o"));
    List<List<String>> result = P28.lsort(input);
    assertThat(result, is(equalTo(Arrays.asList(Arrays.asList("o"), Arrays.asList("d", "e"), Arrays.asList("d", "e"), Arrays.asList("m", "n"), Arrays.asList("a", "b", "c"), Arrays.asList("f", "g", "h"), Arrays.asList("i", "j", "k")))));
}
```

b) Again, we suppose that a list (InList) contains elements that are lists themselves. But this time the objective is to sort the elements of InList according to their **length frequency**; i.e. in the default, where sorting is done in ascending order, lists with rare lengths are placed first, others with a more frequent length come later.

```java
@Test
public void shouldSortByLengthFrequency() throws Exception {
    List<List<String>> input = Arrays.asList(Arrays.asList("a", "b", "c"), Arrays.asList("d", "e"), Arrays.asList("f", "g", "h"), Arrays.asList("d", "e"), Arrays.asList("i", "j", "k", "l"), Arrays.asList("m", "n"), Arrays.asList("o"));
    List<List<String>> result = P28.lfsort(input);
    assertThat(result, is(equalTo(Arrays.asList(Arrays.asList("i", "j", "k", "l"), Arrays.asList("o"), Arrays.asList("a", "b", "c"), Arrays.asList("f", "g", "h"), Arrays.asList("d", "e"), Arrays.asList("d", "e"), Arrays.asList("m", "n")))));
}
```

## Arithmetic

### [P31](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P31.java) **(\*\*) Determine whether a given integer number is prime.**

```java
@Test
public void shouldSay7IsAPrimeNumber() throws Exception {
    boolean prime = P31.isPrime(7);
    assertTrue(prime);
}

@Test
public void shouldSay10IsNotAPrimeNumber() throws Exception {
    boolean prime = P31.isPrime(10);
    assertFalse(prime);
}
```

### [P32](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P32.java) **(\*\*) Determine the prime factors of a given positive integer.**

```java
@Test
public void shouldFindPrimeFactorsOf315() throws Exception {
    List<Integer> primeFactors = P32.primeFactors(315);
    assertThat(primeFactors, hasItems(3, 3, 5, 7));
}

@Test
public void shouldFindPrimeFactorsOf33() throws Exception {
    List<Integer> primeFactors = P32.primeFactors(33);
    assertThat(primeFactors, hasItems(3, 11));
}
```


### [P33](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P33.java) **(\*\*) Determine the prime factors of a given positive integer (2).**


```java
@Test
public void shouldFindPrimeFactorsOf315() throws Exception {
    List<SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult(315);
    assertThat(primeFactors, hasItems(new SimpleEntry<>(3, 2), new SimpleEntry<>(5, 1), new SimpleEntry<>(7, 1)));
}

@Test
public void shouldFindPrimeFactorsOf33() throws Exception {
    List<SimpleEntry<Integer, Integer>> primeFactors = P33.primeFactorsMult(33);
    assertThat(primeFactors, hasItems(new SimpleEntry<>(3, 1), new SimpleEntry<>(11, 1)));
}
```

### [P34](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P34.java) **(*) A list of prime numbers**

```java
import java.util.stream.IntStream;

@Test
public void shouldGiveAllPrimeNumbersBetween2And10() throws Exception {
    List<Integer> primeNumbers = P34.primeNumbers(IntStream.rangeClosed(2, 10));
    assertThat(primeNumbers, hasSize(4));
    assertThat(primeNumbers, hasItems(2, 3, 5, 7));
}

@Test
public void shouldGiveAllPrimeNumbersBetween7And31() throws Exception {
    List<Integer> primeNumbers = P34.primeNumbers(IntStream.rangeClosed(7, 31));
    assertThat(primeNumbers, hasSize(8));
    assertThat(primeNumbers, hasItems(7, 11, 13, 17, 19, 23, 29, 31));
}
```

### [P35](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P35.java) **(\*\*)  Goldbach's conjecture.**

Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers. Example: `28 = 5 + 23`. It is one of the most famous facts in number theory that has not been proved to be correct in the general case. It has been numerically confirmed up to very large numbers. Write a predicate to find the two prime numbers that sum up to a given even integer.

```java
@Test
public void _8_isthesumof_3_and_5() throws Exception {
    List<Integer> numbers = P35.goldbach(8);
    assertThat(numbers, hasSize(2));
    assertThat(numbers, hasItems(3, 5));
}

@Test
public void _28_isthesumof_5_and_23() throws Exception {
    List<Integer> numbers = P35.goldbach(28);
    assertThat(numbers, hasSize(2));
    assertThat(numbers, hasItems(5, 23));
}
```

### [P36](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P36.java) **(\*\*)  A list of Goldbach compositions.**

Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.

```java
@Test
public void shouldProduceAListOfGoldbachCompositions() throws Exception {
    List<SimpleEntry<Integer, List<Integer>>> compositions = P36.goldbach_list(IntStream.rangeClosed(9, 20));
    assertThat(compositions, hasSize(6));
    assertThat(compositions, hasItems(
            new SimpleEntry<>(10, Arrays.asList(3, 7)),
            new SimpleEntry<>(12, Arrays.asList(5, 7)),
            new SimpleEntry<>(14, Arrays.asList(3, 11)),
            new SimpleEntry<>(16, Arrays.asList(3, 13)),
            new SimpleEntry<>(18, Arrays.asList(5, 13)),
            new SimpleEntry<>(20, Arrays.asList(3, 17))
    ));
}

@Test
public void shouldProduceAListOfGoldbachCompositionsWhereBothPrimeNumbersAreGreaterThan50() throws Exception {
    List<SimpleEntry<Integer, List<Integer>>> compositions = P36.goldbach_list1(IntStream.rangeClosed(1, 2000), 50);
    assertThat(compositions, hasSize(4));
    assertThat(compositions, hasItems(
            new SimpleEntry<>(992, Arrays.asList(73, 919)),
            new SimpleEntry<>(1382, Arrays.asList(61, 1321)),
            new SimpleEntry<>(1856, Arrays.asList(67, 1789)),
            new SimpleEntry<>(1928, Arrays.asList(61, 1867))
    ));
}
```

### [P37](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P37.java) **(\*\*)  Determine the greatest common divisor of two positive integer numbers.**

Use Euclid's algorithm.

```java
@Test
public void gcdOf36And63Is9() throws Exception {
    int gcd = P37.gcd(36, 63);
    assertThat(gcd, equalTo(9));
}
```

### [P38](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P38.java) **(*)  Determine whether two positive integer numbers are coprime.**

Two numbers are coprime if their greatest common divisor equals 1.

```java
@Test
public void shouldSay35And64IsCoprime() throws Exception {
    boolean coprime = P38.coprime(35, 64);
    assertTrue(coprime);
}
```

### [P39](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P39.java) **(\*\*)  Calculate Euler's totient function phi(m).**

Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r < m) that are coprime to m.

```java
@Test
public void shouldSayPhiOf10Is4() throws Exception {
    long phi = P39.phi(10);
    assertThat(phi, equalTo(4L));
}
```

### [P40](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P40.java) **(\*\*)  Calculate Euler's totient function phi(m) (2).**

See problem P39 for the definition of Euler's totient function. If the list of the prime factors of a number m is known in the form of problem 2.03 then the function phi(m) can be efficiently calculated as follows: Let `[[p1,m1],[p2,m2],[p3,m3],...]` be the list of prime factors (and their multiplicities) of a given number m. Then phi(m) can be calculated with the following formula:

`phi(m) = (p1 - 1) * p1**(m1 - 1) * (p2 - 1) * p2**(m2 - 1) * (p3 - 1) * p3**(m3 - 1) * ...`

Note that a**b stands for the b'th power of a.


```java
@Test
public void phiOf10Is4() throws Exception {
    int p = P40.phi(10);
    assertThat(p, equalTo(4));
}

@Test
public void phiOf99Is60() throws Exception {
    int p = P40.phi(99);
    assertThat(p, equalTo(60));
}
```

### [P41](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_02_arithmetic/P41.java) **(*)  Compare the two methods of calculating Euler's totient function.**

Use the solutions of problems P39 and P40 to compare the algorithms. Take the number of logical inferences as a measure for efficiency. Try to calculate `phi(10090)` as an example.

```java
@Test
public void shouldCalculatePhiOf10090UsingP39() throws Exception {
    long p = P39.phi(10090);
    assertThat(p, equalTo(4032L));
}

@Test
public void shouldCalculatePhiOf10090UsingP40() throws Exception {
    long p = P40.phi(10090);
    assertThat(p, equalTo(4032L));
}
```

### [P46](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_03_logic_and_codes/P46.java) **(\*\*)  Truth tables for logical expressions.**

Define predicates and/2, or/2, nand/2, nor/2, xor/2, impl/2 and equ/2 (for logical equivalence) which succeed or fail according to the result of their respective operations; e.g. and(A,B) will succeed, if and only if both A and B succeed. Note that A and B can be Prolog goals (not only the constants true and fail).

A logical expression in two variables can then be written in prefix notation, as in the following example: and(or(A,B),nand(A,B)).

Now, write a predicate table/3 which prints the truth table of a given logical expression in two variables.

```java
@Test
public void shouldGenerateTruthTable() throws Exception {
    String table = P46.table((a, b) -> and(a, or(a, b)));
    String result = "A          B          result\n" +
            "true       true       true\n" +
            "true       false      true\n" +
            "false      true       false\n" +
            "false      false      false";

    assertThat(table, is(equalTo(result)));
}
```

### [P47](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_03_logic_and_codes/P47.java) **(*)  Truth tables for logical expressions (2).**

Skipping this problem for now.

### [P48](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_03_logic_and_codes/P48.java) **(\*\*)  Truth tables for logical expressions (3).**

Skipping this problem for now.


### [P49](https://github.com/shekhargulati/99-problems/blob/master/java8/src/main/java/com/shekhargulati/ninetynine_problems/_03_logic_and_codes/P49.java) **(\*\*)  Gray code.**

An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
```
n = 1: C(1) = ['0','1'].
n = 2: C(2) = ['00','01','11','10'].
n = 3: C(3) = ['000','001','011','010','110','111','101','100'].
```
```java
@Test
public void shouldFindGrayCodeWhenNIs1() throws Exception {
    List<String> graySequence = P49.gray(1);
    assertThat(graySequence, contains("0", "1"));
}

@Test
public void shouldFindGrayCodeWhenNIs2() throws Exception {
    List<String> graySequence = P49.gray(2);
    assertThat(graySequence, contains("00", "01", "11", "10"));
}

@Test
public void shouldFindGrayCodeWhenNIs3() throws Exception {
    List<String> graySequence = P49.gray(3);
    assertThat(graySequence, contains("000", "001", "011", "010", "110", "111", "101", "100"));
}
```
