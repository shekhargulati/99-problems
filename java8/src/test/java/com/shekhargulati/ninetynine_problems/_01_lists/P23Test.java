package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class P23Test {

    @Test
    public void shouldReturnAListOfThreeRandomSelectedElements() throws Exception {
        List<String> result = P23.randomSelect(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        System.out.println(result);
        assertThat(result, hasSize(3));
    }

    @Test
    public void shouldReturnAListOfThreeRandomSelectedElements_recursive() throws Exception {
        List<String> result = P23.randomSelectR(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        System.out.println(result);
        assertThat(result, hasSize(3));
    }


    @Test
    public void shouldReturnAListOfThreeRandomSelectedElements_imperative() throws Exception {
        List<String> result = P23.randomSelect_imperative(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        System.out.println(result);
        assertThat(result, hasSize(3));
    }
}