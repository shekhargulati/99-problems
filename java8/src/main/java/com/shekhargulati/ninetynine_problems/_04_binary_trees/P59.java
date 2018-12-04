package com.shekhargulati.ninetynine_problems._04_binary_trees;

import java.util.List;

/**
 *   (*) Collect the internal nodes of a binary tree in a list
 */
public class P59 {

    /**
     * Common Tree Class
     *
     * implements {@link Comparable}
     * @param <T> extends {@link Comparable } the id for each node
     */
    public static class Node<T extends Comparable<T>> implements Comparable<Node<T>>{

        T id;
        Node<T> left;
        Node<T> right;

        public Node(T id){
            this.id=id;
        }

        /**
         * To compare two nodes
         *
         * @param node {@link Node} the instance of the node class
         * @return the positive or negative value after comparing two nodes
         */
        @Override
        public int compareTo(Node<T> node) {
            if (this.id.compareTo(node.id) > 0) return 1;
            else if (this.id.compareTo(node.id) == 0) return 0;
            else return -1;
        }
    }

    /**
     * To collect the internal nodes of a binary tree in a list
     *
     * @param root {@link Node} the binary tree
     * @param S {@link List} list of internal nodes of a binary tree
     * @return {@link List} of {@link Node} List of internal nodes of a binary tree
     */
    public static List<Node> internals(Node root, List<Node> S){
        if(root==null || (root.left==null && root.right==null))   return S;
        S.add(root);
        if(root.left!=null)  S=internals(root.left, S);
        if(root.right!=null) S=internals(root.right,S);
        return S;
    }
}
