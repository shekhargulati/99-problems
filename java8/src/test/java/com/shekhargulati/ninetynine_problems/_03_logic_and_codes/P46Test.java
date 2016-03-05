package com.shekhargulati.ninetynine_problems._03_logic_and_codes;

import org.junit.Test;

import static com.shekhargulati.ninetynine_problems._03_logic_and_codes.P46.and;
import static com.shekhargulati.ninetynine_problems._03_logic_and_codes.P46.or;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class P46Test {

    @Test
    public void shouldGenerateTruthTable() throws Exception {
        String table = P46.table((a, b) -> and(a, or(a, b)));
        String result = "A          B          result\n" +
                "true       true       true\n" +
                "true       false      true\n" +
                "false      true       false\n" +
                "false      false      false";

        assertThat(table, is(equalTo(result)));
    }
}