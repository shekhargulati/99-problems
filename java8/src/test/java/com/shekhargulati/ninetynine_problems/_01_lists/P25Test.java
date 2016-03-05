package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class P25Test {

    @Test
    public void shouldGenerateRandomPermutationOfElementsOfAList() throws Exception {
        List<String> permutation = P25.randomPermutation(Stream.of("a", "b", "c", "d", "e", "f").collect(toList()));
        System.out.println(permutation);
        assertThat(permutation, hasSize(6));
        assertThat(permutation, containsInAnyOrder("a", "b", "c", "d", "e", "f"));
    }
}