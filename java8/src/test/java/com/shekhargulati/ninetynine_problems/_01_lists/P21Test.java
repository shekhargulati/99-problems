package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class P21Test {

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

    @Test
    public void shouldInsertElementAtSecondPosition_split() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = P21.insertAt_split(input, 2, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("a", "alfa", "b", "c", "d"));

    }

    @Test
    public void shouldInsertElementAtFirstPosition_split() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = P21.insertAt_split(input, 1, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("alfa", "a", "b", "c", "d"));

    }

    @Test
    public void shouldInsertElementAtEnd_split() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d").collect(toList());
        List<String> result = P21.insertAt_split(input, 5, "alfa");
        assertThat(result, hasSize(5));
        assertThat(result, contains("a", "b", "c", "d", "alfa"));
    }
}