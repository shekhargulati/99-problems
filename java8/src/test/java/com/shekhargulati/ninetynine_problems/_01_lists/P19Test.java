package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class P19Test {

    @Test
    public void shouldRotateAListByThreeElementsWhenNIs3() throws Exception {
        List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 3);
        assertThat(rotated, equalTo(Arrays.asList("d", "e", "f", "g", "h", "a", "b", "c")));
    }

    @Test
    public void shouldReturnSameListWhenNIs0() throws Exception {
        List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), 0);
        assertThat(rotated, equalTo(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h")));
    }

    @Test
    public void shouldRotateWhenNIsNegative() throws Exception {
        List<String> rotated = P19.rotate(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"), -2);
        assertThat(rotated, equalTo(Arrays.asList("g", "h", "a", "b", "c", "d", "e", "f")));
    }


}