package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class P24Test {

    @Test
    public void shouldGive6RandomNumbersFromARangeStartingFrom1To49() throws Exception {
        List<Integer> randomList = P24.randomSelect(6, 1, 49);
        assertThat(randomList, hasSize(6));
        System.out.println(randomList); // One possible output [47, 30, 36, 38, 11, 1]
    }
}