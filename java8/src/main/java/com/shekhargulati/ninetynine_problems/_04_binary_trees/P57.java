package com.shekhargulati.ninetynine_problems._04_binary_trees;

/**
 *  (*) Count the leaves of a binary tree
 */
public class P57 {

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
        public int compareTo(Node<T> node){
            if(this.id.compareTo(node.id)==0)   return 0;
            if(this.id.compareTo(node.id)>0)    return 1;
            return -1;
        }
    }
    /**
     * To count the leaves on a binary tree
     *
     * @param root {@link Node} the binary tree
     * @param N the count of leaves
     * @return integer the count of leaves
     */
    public static int count_leaves(Node root, int N){
        if(root==null)     return N;
        else if(root.left==null && root.right==null)         N++;
        else if(root.left != null && root.right==null)       N+=count_leaves(root.left,N);
        else if(root.left == null && root.right!=null)       N+=count_leaves(root.right,N);
        else    N+=count_leaves(root.left,N)+count_leaves(root.right,N);
        return N;
    }
}