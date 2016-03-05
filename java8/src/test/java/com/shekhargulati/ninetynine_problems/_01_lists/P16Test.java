package com.shekhargulati.ninetynine_problems._01_lists;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class P16Test {

    @Test
    public void shouldDropEveryNthElement() throws Exception {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3);
        assertThat(result, hasSize(8));
        assertThat(result, contains("a", "b", "d", "e", "g", "h", "j", "k"));
    }

    @Test
    public void shouldReturnSameListWhenNIsLessThanListSize() throws Exception {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b"), 3);
        assertThat(result, hasSize(2));
        assertThat(result, contains("a", "b"));
    }

    @Test
    public void shouldReturnSameListWhenNIsZero() throws Exception {
        List<String> result = P16.dropEveryNth(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0);
        assertThat(result, hasSize(11));
        assertThat(result, contains("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
    }


}