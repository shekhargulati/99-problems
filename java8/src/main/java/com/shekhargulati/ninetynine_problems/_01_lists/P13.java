package com.shekhargulati.ninetynine_problems._01_lists;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * <b>(**) Run-length encoding of a list (direct solution)</b>
 */
public class P13 {

    public static List<SimpleEntry<Integer, String>> encode_direct(List<String> list) {
        LinkedList<SimpleEntry<Integer, String>> result = new LinkedList<>();
        String lastElem = null;
        for (String elem : list) {
            if (Objects.equals(lastElem, elem)) {
                SimpleEntry<Integer, String> last = result.removeLast();
                result.add(new SimpleEntry<>(last.getKey() + 1, elem));
            } else {
                result.add(new SimpleEntry<>(1, elem));
                lastElem = elem;
            }
        }
        return result;
    }

}
