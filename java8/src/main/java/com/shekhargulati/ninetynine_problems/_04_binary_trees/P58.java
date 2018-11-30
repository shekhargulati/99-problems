package com.shekhargulati.ninetynine_problems._04_binary_trees;

import java.util.List;

/**
 * (*) Collect the leaves of a binary tree in a list
 */
public class P58 {

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

        public Node(T id){ this.id=id; }

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
     * To list the leaves on a binary tree
     *
     * @param root {@link Node} the binary tree
     * @param S {@link List} the list of leaves
     * @return {@link List} the list of leaves
     */
    public static List<Node> leaves(Node root, List<Node> S){
        if(root==null)     return S;
        else if(root.left==null && root.right==null)         S.add(root);
        else if(root.left != null && root.right==null)      leaves(root.left,S);
        else if(root.left == null && root.right!=null)      leaves(root.right,S);
        else{
            leaves(root.left,S);
            leaves(root.right,S);
        }
        return S;
    }
}