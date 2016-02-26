package com.shekhargulati.ninetynine_problems.java8._00_random.tadm.ch03;

import java.util.Optional;
import java.util.TreeSet;

/**
 * <p>In the bin-packing problem, we are given n metal objects, each weighing between zero and one kilogram.
 * Our goal is to find the smallest number of bins that will hold the n objects, with each bin holding one kilogram at most.</p>
 * <p>
 * <p>*  The best-fit heuristic for bin packing is as follows. Consider the objects in the order in which they are given.
 * For each object, place it into the partially filled bin with the smallest amount of extra room after the object is inserted.
 * If no such bin exists, start a new bin. Design an algorithm that implements the best-fit heuristic
 * (taking as input the n weights w1,w2,...,wn and outputting the number of bins used) in O(n log n) time.</p>
 * <p>
 * <p>* Repeat the above using the worst-fit heuristic, where we put the next object in the partially filled bin with the
 * largest amount of extra room after the object is inserted.</p>
 */
public class Problem3_10 {

    public static void main(String[] args) {
        Problem3_10 p = new Problem3_10();
        System.out.println(p.numberOfBins(new int[]{100, 200, 600, 500, 400, 1000}));
        System.out.println(p.numberOfBins(new int[]{100, 200, 300, 400}));
    }

    public int numberOfBins(int[] weights) {

        TreeSet<Bin> bins = new TreeSet<>();
        /*
         * Iterate over all the weights in an array
         * For each weight find the bin which will have least remaining space after weight is put
         * If the bin is found then update its data
         * else create a new bin and add it to the set
         */

        for (int weight : weights) {
            Optional<Bin> foundBin = Optional.empty();
            if (!bins.isEmpty()) {
                foundBin = findBin(bins, weight);
            }
            if (foundBin.isPresent()) {
                foundBin.get().updateCurrentConsumption(weight);
            } else {
                bins.add(new Bin(weight));
            }
        }
        return bins.size();
    }

    private Optional<Bin> findBin(TreeSet<Bin> bins, int weight) {
        return bins.stream().filter(b -> b.remaining() >= weight).findFirst();
    }

}

class Bin implements Comparable<Bin> {
    final int max = 1000;
    int currentConsumption = 0;

    public Bin(int currentConsumption) {
        this.currentConsumption = currentConsumption;
    }

    public Bin updateCurrentConsumption(int weight) {
        if (this.remaining() - weight > 0) {
            this.currentConsumption += weight;
        }
        return this;
    }

    public int remaining() {
        return this.max - this.currentConsumption;
    }


    @Override
    public int compareTo(Bin o) {
        return this.remaining() - o.remaining();
    }
}