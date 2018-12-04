package com.shekhargulati.ninetynine_problems._04_binary_trees;

import java.util.List;

/**
 *   (*) Collect the nodes at a given level in a list
 */
public class P60 {

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
            if(this.id.compareTo(node.id)==0){
                return 0;
            }else if(this.id.compareTo(node.id)>0){
                return 1;
            }else{
                return -1;
            }
        }
    }

    /**
     * To collect the nodes at a given level in a list
     *
     * @param root {@link Node} the binary tree
     * @param S {@link List} list of nodes of a binary tree at a specific level
     * @param L the level at which we need to collect nodes
     * @return {@link List} of {@link Node} list of nodes of a binary tree at a specific level
     */
    public static List<Node> atLevel(Node root, List<Node> S, int L){
        if(root==null)  return S;
        if(L==1){
            S.add(root);
            return S;
        }
        if(root.left!=null)     S=atLevel(root.left, S, L-1);
        if(root.right!=null)    S=atLevel(root.right, S, L-1);
        return S;
    }
}