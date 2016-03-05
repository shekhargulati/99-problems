package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class P20Test {

    @Test
    public void shouldRemoveKthElementFromList() throws Exception {
        Object[] result = P20.removeAt(Arrays.asList("a", "b", "c", "d"), 2);
        assertThat(result[0], equalTo(Arrays.asList("a", "c", "d")));
        assertThat(result[1], equalTo("b"));
    }

    @Test
    public void shouldRemoveKthElementFromList_() throws Exception {
        Object[] result = P20.removeAt_splitAt(Arrays.asList("a", "b", "c", "d"), 2);
        assertThat(result[0], equalTo(Arrays.asList("a", "c", "d")));
        assertThat(result[1], equalTo("b"));
    }
}