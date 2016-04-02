package com.shekhargulati.tadm.ch04.excercises;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class Problem4_1Test {

    @Test
    public void shouldDistributePlayersIntoTwoUnfairTeams() throws Exception {
        List<Player> players = Arrays.asList(new Player("a", 10), new Player("b", 7), new Player("c", 11), new Player("d", 2), new Player("e", 4), new Player("f", 15));

        List<List<Player>> teams = Problem4_1.teams(players);
        assertThat(teams.get(0), CoreMatchers.equalTo(Arrays.asList(new Player("d", 2), new Player("e", 4), new Player("b", 7))));
        assertThat(teams.get(1), CoreMatchers.equalTo(Arrays.asList(new Player("a", 10), new Player("c", 11), new Player("f", 15))));

    }
}