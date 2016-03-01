package com.shekhargulati.tadm.ch03;

import java.util.Optional;

/**
 * Write a data structure that supports following operations.
 * <p>
 * insert(x,T) – Insert item x into the set T
 * delete(k,T) – Delete the kth smallest element from T.
 * member(x,T) – Return true iff x ∈ T .
 * All operations must take O(log n) time on an n-element set.
 */
public class Problem3_8 {

    public static void main(String[] args) {
        Tree<Integer> numbers = new Tree<>(40);
        numbers.insert(21);
        numbers.insert(10);
        numbers.insert(30);
        numbers.insert(50);

        System.out.println(numbers);

        System.out.println(numbers.find(6));
        System.out.println(numbers.find(2));
        System.out.println(numbers.find(5));
    }

}

class Tree<T extends Comparable<? super T>> {

    Node<T> node;
    Tree<T> left;
    Tree<T> right;

    public Tree(T t) {
        this.node = new Node<>(t);
    }

    public void insert(T t) {
        if (t.compareTo(this.node.data) < 0) {
            this.node.leftCount++;
            if (this.left == null) {
                this.left = new Tree<>(t);
            } else {
                this.left.insert(t);
            }
        } else if (t.compareTo(this.node.data) > 0) {
            this.node.rightCount++;
            // save to right tree
            if (this.right == null) {
                this.right = new Tree<>(t);
            } else {
                this.right.insert(t);
            }
        } else {
            throw new IllegalArgumentException(String.format("%s is already present in the binary tree", t));
        }

    }

    public boolean member(T t) {
        if (t.compareTo(this.node.data) < 0) {
            return this.left != null && this.left.member(t);
        } else if (t.compareTo(this.node.data) > 0) {
            return this.right != null && this.right.member(t);
        }
        return true;
    }

    public Optional<T> find(int k) {
        if (k == this.node.leftCount + 1) {
            return Optional.of(this.node.data);
        } else if (k > this.node.leftCount) {
            k = k - (this.node.leftCount + 1);
            return this.right == null ? Optional.empty() : this.right.find(k);
        } else {
            return this.left == null ? Optional.empty() : this.left.find(k);
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "node=" + node +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class Node<T> {

    T data;
    int leftCount;
    int rightCount;

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftCount=" + leftCount +
                ", rightCount=" + rightCount +
                '}';
    }
}
