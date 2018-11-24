package com.shekhargulati.ninetynine_problems._04_binary_trees;

/**
 * (*) Check whether a given term represents a binary tree
 */
public class P50 {

    /**
     * Common Tree Class
     *
     * implements {@link Comparable}
     * @param <T> extends {@link Comparable } the id for each node
     */
    public static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        T id;
        Node<T> left;
        Node<T> right;

        public Node(T id){
            this.id=id;
            this.left=null;
            this.right=null;
        }

        /**
         * To compare two nodes
         *
         * @param object {@link Node} the instance of the node class
         * @return the positive or negative value after comparing two nodes
         * */
        @Override
        public int compareTo(Node<T> object){
            return this.id.compareTo(object.id)>0?1:-1;
        }
    }

    /**
     * To see if the input is a binary tree or not
     *
     * @param node {@link Node}
     * @return true or false depending the tree is binary or not
     */
    public static boolean isTree(Node node){
        if(node==null || (node.left==null && node.left==null)){
            return true;
        }
        if(node.left!=null){
            if(node.compareTo(node.left)>0){
                if(!isTree(node.left)){
                    return false;
                }
            }else {
                return false;
            }
        }
        if(node.right!=null){
            if(node.compareTo(node.right)<0){
                if(!isTree(node.right)){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
