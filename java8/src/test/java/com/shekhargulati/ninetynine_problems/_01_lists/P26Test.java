package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class P26Test {

    @Test
    public void shouldFindAllCombinationsOfSize2FromAListWithSize3() throws Exception {
        List<String> input = Stream.of("a", "b", "c").collect(toList());
        List<List<String>> combinations = P26.combinations(input, 2);
        assertThat(combinations, hasSize(3));
    }


    @Test
    public void shouldFindAllCombinationsOfSize3FromAListWithSize6() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(toList());
        List<List<String>> combinations = P26.combinations(input, 3);
        assertThat(combinations, hasSize(20));
    }

    @Test
    public void shouldFindAllCombinationsOfSize4FromAListWithSize6() throws Exception {
        List<String> input = Stream.of("a", "b", "c", "d", "e", "f").collect(toList());
        List<List<String>> combinations = P26.combinations(input, 4);
        assertThat(combinations, hasSize(15));
    }
}