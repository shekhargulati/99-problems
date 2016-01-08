package com.shekhargulati.ninetynine_problems.java8.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static com.shekhargulati.ninetynine_problems.java8.lists.P26.combinations;
import static java.util.stream.Collectors.toList;

/**
 * (**) Group the elements of a set into disjoint subsets
 */
public class P27 {

    /**
     * In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons?
     * Write a predicate that generates all the possibilities via backtracking
     */
    public static <T> List<List<List<T>>> group3(List<T> list) {
        /*
        1. Find all the combinations of 2
        2. For each combination of 2 find combination of 3 in the remaining list
        3. add combination of 2, 3 and remaining to the result
         */

        List<List<List<T>>> result = new ArrayList<>();

        for (List<T> combinationOf2 : combinations(list, 2)) {
            List<T> r = remaining(list, combinationOf2);
            for (List<T> combinationOf3 : combinations(r, 3)) {
                result.add(Stream.of(combinationOf2, combinationOf3, remaining(r, combinationOf3)).collect(toList()));
            }
        }

        return result;
    }


    public static <T> List<List<T>> group(List<T> list, List<Integer> gss) {
        if (gss.isEmpty()) return new ArrayList<>();

        Integer n = gss.get(0);
        List<Integer> ns = gss.subList(1, gss.size());
        return combinations(list, n)
                .stream()
                .flatMap(c -> {
                    List<T> r = remaining(list, c);
                    List<List<T>> res = new ArrayList<>();
                    List<List<T>> group = group(r, ns);
                    for (List<T> ts : group) {
                        c.addAll(ts);
                    }
                    res.add(c);
                    return res.stream();
                })
                .collect(toList());
    }

    /**
     * Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups
     */
    public static <T> List<List<List<T>>> group(List<T> list, List<Integer> gss, int skip) {
        return Collections.emptyList();
    }


    private static <T> List<T> remaining(List<T> list, List<T> c) {
        return list.stream().filter(e -> !c.contains(e)).collect(toList());
    }
}
