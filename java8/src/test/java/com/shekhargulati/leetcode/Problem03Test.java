package com.shekhargulati.leetcode;

import com.shekhargulati.leetcode.algorithms.Problem03;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class Problem03Test {

    @Test
    public void shouldFindLongestSubstring() throws Exception {
        final String input = "abcabc";
        String substring = Problem03.substring(input);
        assertThat(substring, equalTo("abc"));
    }

    @Test
    public void shouldFindLongestSubstringIn_bbbbb() throws Exception {
        final String input = "bbbb";
        String substring = Problem03.substring(input);
        assertThat(substring, equalTo("b"));
    }
}