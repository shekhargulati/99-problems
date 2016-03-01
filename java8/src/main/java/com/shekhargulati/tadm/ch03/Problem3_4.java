package com.shekhargulati.tadm.ch03;

/**
 * Design a dictionary data structure in which search, insertion, and deletion can all be processed in O(1) time
 * in the worst case.
 * You may assume the set elements are integers drawn from a finite set 1, 2, .., n, and initialization can take O(n) time.
 */
public class Problem3_4 {

    /*
    The solution can be implemented using an array as we have a finite dataset as shown below.
     */


}


class Dictionary {

    private int[] arr;

    public Dictionary(int n) {
        this.arr = new int[n];
    }

    public void insert(int el) {
        this.arr[el - 1] = el;
    }

    public int search(int el) {
        return this.arr[el - 1];
    }


    public void delete(int el) {
        this.arr[el - 1] = -1;
    }
}