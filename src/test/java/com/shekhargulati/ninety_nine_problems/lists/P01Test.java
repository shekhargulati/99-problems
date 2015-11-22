package com.shekhargulati.ninety_nine_problems.lists;

import org.junit.Test;

import java.util.LinkedList;

import static com.shekhargulati.ninety_nine_problems.lists.P01.*;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class P01Test {

    @Test
    public void shouldFindLastElementFromAListOfNumbers() throws Exception {
        assertThat(last(asList(1, 1, 2, 3, 5, 8)), is(equalTo(8)));
    }

    @Test
    public void shouldFindLastElementFromALinkedListOfNumbers() throws Exception {
        LinkedList<Integer> numbers = linkedList(1, 1, 2, 3, 5, 8);
        assertThat(last(numbers), is(equalTo(8)));
    }

    @Test
    public void shouldFindLastElementFromAListOfNumbersUsingRecursion() throws Exception {
        assertThat(lastRecursive(asList(1, 1, 2, 3, 5, 8)), is(equalTo(8)));
    }


}