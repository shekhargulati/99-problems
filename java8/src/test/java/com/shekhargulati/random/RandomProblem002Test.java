package com.shekhargulati.random;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomProblem002Test {

    @Test
    public void shouldGiveTrueWhenPatternExistInText() throws Exception {
        String text = Files.lines(Paths.get("src", "test", "resources", "book.txt")).collect(joining());
        boolean patternExists = RandomProblem002.patternExistInText(text, "prudent");
        assertTrue(patternExists);
    }

    @Test
    public void shouldGiveFalseWhenPatternDoesNotExistInText() throws Exception {
        String text = Files.lines(Paths.get("src", "test", "resources", "book.txt")).collect(joining());
        boolean patternExists = RandomProblem002.patternExistInText(text, "awesome");
        assertFalse(patternExists);
    }
}