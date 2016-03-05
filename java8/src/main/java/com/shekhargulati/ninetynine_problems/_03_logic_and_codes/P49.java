package com.shekhargulati.ninetynine_problems._03_logic_and_codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * (**) Gray code.
 * An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
 * n = 1: C(1) = ['0','1'].
 * n = 2: C(2) = ['00','01','11','10'].
 * n = 3: C(3) = ['000','001','011','010','110','111','101','100'].
 */
public class P49 {

    public static List<String> gray(int n) {
        if (n == 1) {
            return Arrays.asList("0", "1");
        }
        List<String> original = gray(n - 1);
        List<String> reversed = new ArrayList<>(original);
        Collections.reverse(reversed);
        return Stream.concat(original.stream().map(s -> "0" + s), reversed.stream().map(s -> "1" + s)).collect(toList());
    }
}
