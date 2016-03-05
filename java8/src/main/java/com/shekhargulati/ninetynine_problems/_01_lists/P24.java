package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.List;

/**
 * (*) Lotto: Draw N different random numbers from the set 1..M
 */
public class P24 {

    public static List<Integer> randomSelect(int n, int start, int end) {
        return P23.randomSelect(P22.range(start, end), n);
    }
}
