package com.shekhargulati.ninetynine_problems.java8.lists;

import org.junit.Test;

import java.util.LinkedList;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class P01Test {

    @Test
    public void shouldFindLastElementFromAListOfNumbers() throws Exception {
        assertThat(P01.last(asList(1, 1, 2, 3, 5, 8)), is(equalTo(8)));
    }

    @Test
    public void shouldFindLastElementFromALinkedListOfNumbers() throws Exception {
        LinkedList<Integer> numbers = P01.linkedList(1, 1, 2, 3, 5, 8);
        assertThat(P01.last(numbers), is(equalTo(8)));
    }

    @Test
    public void shouldFindLastElementFromAListOfNumbersUsingRecursion() throws Exception {
        assertThat(P01.lastRecursive(asList(1, 1, 2, 3, 5, 8)), is(equalTo(8)));
    }


}