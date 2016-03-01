package com.shekhargulati.tadm.ch03;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * We have seen how dynamic arrays enable arrays to grow while still achieving constant-time amortized performance.
 * This problem concerns extending dynamic arrays to let them both grow and shrink on demand.
 * (a) Consider an underflow strategy that cuts the array size in half whenever the array falls below half full.
 * Give an example sequence of insertions and deletions where this strategy gives a bad amortized cost.
 * (b) Then, give a better underflow strategy than that suggested above, one that achieves constant amortized cost per deletion.
 */
public class Problem3_3 {

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray();
        IntStream.rangeClosed(1, 5).forEach(arr::add);
        arr.remove1(1);
        arr.add(1);
        arr.remove1(3);
        arr.add(2);

    }

}

class DynamicArray {

    int[] arr;
    int size;

    public DynamicArray() {
        this.arr = new int[1];
    }

    public void add(int el) {
        if (this.arr.length == this.size) {
            this.arr = Arrays.copyOf(this.arr, this.size * 2);
        }
        this.arr[this.size++] = el;
    }

    public boolean remove1(int el) {
        int found = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == el) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            return false;
        }

        this.size--;
        System.arraycopy(this.arr, found + 1, this.arr, found, this.size - found);
        for (int i = this.size; i < this.arr.length; i++) {
            this.arr[i] = 0;
        }
        if (this.size == this.arr.length / 2) {
            int[] copy = new int[this.arr.length / 2];
            System.arraycopy(arr, 0, copy, 0, copy.length);
            this.arr = copy;
        }
        return true;
    }

    public boolean remove2(int el) {
        /*
        Search the first occurrence of the element in the array. Iterate only till size
        If element is not found return false
        Else move all the elements up by one place
            -> and decrement size by 1
         */
        int found = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] == el) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            return false;
        }
        size--;
        int[] copy = new int[size];
        System.arraycopy(arr, 0, copy, 0, found);
        System.arraycopy(this.arr, found + 1, copy, found, this.size - found);
        this.arr = copy;
        return true;
    }

    public int getSize() {
        return size;
    }
}