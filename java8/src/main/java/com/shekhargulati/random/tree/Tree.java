package com.shekhargulati.random.tree;

import java.util.Objects;

public class Tree<T> {

    T item;
    Tree<T> left;
    Tree<T> right;
    Tree<T> parent;
}

class TreeOperations {

    public <T extends Comparable<? super T>> Tree<T> search(Tree<T> tree, T item) {
        if (Objects.equals(tree.item, item)) {
            return tree;
        }
        if (tree.item.compareTo(item) < 0) {
            return search(tree.left, item);
        } else {
            return search(tree.right, item);
        }
    }

    public <T> T min(Tree<T> tree) {
        if (tree.left == null) {
            return tree.item;
        }
        return min(tree.left);
    }

    public <T> T max(Tree<T> tree) {
        if (tree.right == null) {
            return tree.item;
        }
        return max(tree.right);
    }
}
