package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class P22Test {

    @Test
    public void shouldCreateARangeBetween4And9() throws Exception {
        List<Integer> range = P22.range(4, 9);
        assertThat(range, hasSize(6));
        assertThat(range, contains(4, 5, 6, 7, 8, 9));

    }
}