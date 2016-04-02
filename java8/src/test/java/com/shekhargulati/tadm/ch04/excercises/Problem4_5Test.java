package com.shekhargulati.tadm.ch04.excercises;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class Problem4_5Test {

    @Test
    public void shouldFindMode() throws Exception {
        int mode = Problem4_5.mode(new int[]{4, 6, 6, 3, 3, 3, 2, 4, 3, 1});
        assertThat(mode, CoreMatchers.equalTo(3));

    }
}