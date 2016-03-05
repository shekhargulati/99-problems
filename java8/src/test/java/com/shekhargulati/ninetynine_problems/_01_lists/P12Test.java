package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

public class P12Test {

    @Test
    public void shouldDecodeEncodedList() throws Exception {
        List<String> encoded = P12.decode(
                Arrays.asList(
                        new SimpleEntry<>(4, "a"),
                        "b",
                        new SimpleEntry<>(2, "c"),
                        new SimpleEntry<>(2, "a"),
                        "d",
                        new SimpleEntry<>(4, "e")));

        assertThat(encoded, hasSize(14));
    }
}