package com.shekhargulati.fortytwo_problems;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class Problem01Test {

    @Test
    public void shouldCreatePairsByMinOfMaximumSumOfPairs() throws Exception {
        List<SimpleEntry<Integer, Integer>> pairs = Problem01.pairs(new int[]{1, 9, 3, 5});
        assertThat(pairs, contains(new SimpleEntry<>(1, 9), new SimpleEntry<>(3, 5)));
    }
}