package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;

public class P10Test {

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
}