package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import static com.shekhargulati.ninetynine_problems._01_lists.CollectionUtils.arrayDeque;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class P05Test {

    @Test
    public void shouldReverseAList() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P05.reverse(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }

    @Test
    public void shouldReverseAList_IntStream() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(P05.reverse_IntStream(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }

    @Test
    public void shouldReverseAList_Stream() throws Exception {
        ArrayDeque<Integer> numbers = arrayDeque(1, 2, 3, 4, 5);
        assertThat(P05.reverse_customStream(numbers), is(equalTo(Arrays.asList(5, 4, 3, 2, 1))));
    }
}