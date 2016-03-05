package com.shekhargulati.ninetynine_problems._03_logic_and_codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * 3.01 (**) Truth tables for logical expressions.
 * <p>
 * Define predicates and/2, or/2, nand/2, nor/2, xor/2, impl/2 and equ/2 (for logical equivalence) which succeed or fail according to the result of their respective operations; e.g. and(A,B) will succeed, if and only if both A and B succeed. Note that A and B can be Prolog goals (not only the constants true and fail).
 * <p>
 * A logical expression in two variables can then be written in prefix notation, as in the following example: and(or(A,B),nand(A,B)).
 * Now, write a predicate table/3 which prints the truth table of a given logical expression in two variables.
 */
public class P46 {

    public static String table(BiPredicate<Boolean, Boolean> f) {
        List<String> resultBuilder = new ArrayList<>();
        resultBuilder.add("A          B          result");
        for (boolean a : Arrays.asList(true, false)) {
            for (boolean b : Arrays.asList(true, false)) {
                resultBuilder.add(String.format("%-10s %-10s %s", a, b, f.test(a, b)));
            }
        }
        return resultBuilder.stream().collect(Collectors.joining("\n"));
    }

    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    public static boolean or(boolean a, boolean b) {
        return a || b;
    }
}
