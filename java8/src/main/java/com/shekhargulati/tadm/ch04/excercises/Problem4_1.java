package com.shekhargulati.tadm.ch04.excercises;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Problem4_1 {

    public static List<List<Player>> teams(List<Player> players) {
        List<Player> sorted = players.stream().sorted((p1, p2) -> p1.rating - p2.rating).collect(Collectors.toList());
        int totalPlayers = players.size();
        return Arrays.asList(sorted.subList(0, totalPlayers / 2), sorted.subList(totalPlayers / 2, totalPlayers));
    }

}

class Player {
    String name;
    int rating;

    public Player(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return rating == player.rating &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating);
    }
}