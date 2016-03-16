package com.shekhargulati.codegolf;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Your goal is to make a program that converts an input to its acronym.
 * Your input is guaranteed to have only letters and spaces. The input will have exactly one space between words.
 * You must output the acronym of the input.
 *
 * https://codegolf.stackexchange.com/questions/75448/making-an-acronym
 */
public class AcronymMaker {

    private static final List<String> STOP_WORDS = Arrays.asList("AND", "OR", "BY", "OF");

    public static String acronym(final String input) {
        return Arrays
                .stream(input.toUpperCase().split("\\s"))
                .filter(word -> !STOP_WORDS.contains(word))
                .map(w -> String.valueOf(w.charAt(0)))
                .collect(joining(""));
    }

}
