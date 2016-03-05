package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.shekhargulati.ninetynine_problems._01_lists.P26.combinations;
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


    public static <T> List<List<List<T>>> group(List<T> list, List<Integer> gss) {
        if (gss.isEmpty()) {
            List<List<List<T>>> lists = new ArrayList<>();
            lists.add(new ArrayList<>());
            return lists;
        }
        int n = gss.get(0);
        List<Integer> ns = gss.subList(1, gss.size());
        List<List<List<T>>> result = new ArrayList<>();
        for (List<T> c : combinations(list, n)) {
            List<T> remaining = remaining(list, c);
            for (List<List<T>> cg : group(remaining, ns)) {
                List<List<T>> sg = new ArrayList<>();
                sg.add(c);
                sg.addAll(cg);
                result.add(sg);
            }
        }
        return result;
    }


    private static <T> List<T> remaining(List<T> list, List<T> c) {
        return list.stream().filter(e -> !c.contains(e)).collect(toList());
    }
}
