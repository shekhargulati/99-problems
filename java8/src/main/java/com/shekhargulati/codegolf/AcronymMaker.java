package com.shekhargulati.codegolf;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Your goal is to make a program that converts an input to its acronym.
 * Your input is guaranteed to have only letters and spaces. The input will have exactly one space between words.
 * You must output the acronym of the input.
 */
public class AcronymMaker {

    private static final List<String> STOP_WORDS = Arrays.asList("and", "or", "by", "of");

    public static String acronym(final String input) {
        /*
        Algorithm:
        1. Split string into words
        2. Filter out all the stopwords
        3. Iterate over all the remaining words and take the first char and upper case it
         */
        return Arrays.stream(input.toLowerCase().split("\\s")).filter(word -> !STOP_WORDS.contains(word)).map(w -> String.valueOf(w.charAt(0)).toUpperCase()).collect(joining(""));
    }
}
