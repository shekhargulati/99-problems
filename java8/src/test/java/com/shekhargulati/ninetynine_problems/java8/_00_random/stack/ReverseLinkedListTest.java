package com.shekhargulati.ninetynine_problems.java8._00_random.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReverseLinkedListTest {

    @Test
    public void shouldReverseALinkedList() throws Exception {
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(toCollection(LinkedList::new));
        List<Integer> reversedNumbers = new ReverseLinkedList().reverse(numbers);
        assertThat(reversedNumbers, equalTo(Stream.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1).collect(toCollection(LinkedList::new))));
    }
}