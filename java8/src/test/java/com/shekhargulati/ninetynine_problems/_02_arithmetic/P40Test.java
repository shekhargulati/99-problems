package com.shekhargulati.ninetynine_problems._02_arithmetic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class P40Test {

    @Test
    public void phiOf10Is4() throws Exception {
        int p = P40.phi(10);
        assertThat(p, equalTo(4));
    }

    @Test
    public void phiOf99Is60() throws Exception {
        int p = P40.phi(99);
        assertThat(p, equalTo(60));
    }
}