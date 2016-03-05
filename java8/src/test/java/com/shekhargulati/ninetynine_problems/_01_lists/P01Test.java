package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.LinkedList;

import static com.shekhargulati.ninetynine_problems._01_lists.CollectionUtils.linkedList;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class P01Test {

    @Test
    public void shouldFindLastElementFromAListOfAlphabets() throws Exception {
        assertThat(P01.last(asList("a", "b", "c", "d")), is(equalTo("d")));
    }

    @Test
    public void shouldFindLastElementFromALinkedListOfAlphabets() throws Exception {
        LinkedList<String> alphabets = linkedList("a", "b", "c", "d");
        assertThat(P01.last(alphabets), is(equalTo("d")));
    }

    @Test
    public void shouldFindLastElementFromAListOfAlphabetsUsingRecursion() throws Exception {
        assertThat(P01.lastRecursive(asList("a", "b", "c", "d")), is(equalTo("d")));
    }


}