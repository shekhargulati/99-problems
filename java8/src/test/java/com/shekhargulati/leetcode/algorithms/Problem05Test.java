package com.shekhargulati.leetcode.algorithms;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Problem05Test {

    @Test
    public void shouldDetectLongestPalindrome() throws Exception {
        final String input = "saasdcjkbkjnjnnknvjfknjnfjkvnjkfdnvjknfdkvjnkjfdnvkjnvjknjkgnbjkngkjvnjkgnbvkjngfreyh67ujrtyhytju789oijtnuk789oikmtul0oymmmmmmmmmmmmmmmm";
        String l = Problem05.longestPalindrome(input);
        assertThat(l, equalTo("mmmmmmmmmmmmmmmm"));
    }
}