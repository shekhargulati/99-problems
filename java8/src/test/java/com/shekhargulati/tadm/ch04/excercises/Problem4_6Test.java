package com.shekhargulati.tadm.ch04.excercises;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Problem4_6Test {

    @Test
    public void shouldFindAPair() throws Exception {
        boolean pair = Problem4_6.findPair(new int[]{4, 3, 7}, new int[]{3, 2, 1}, 5);
        assertTrue(pair);
    }
}