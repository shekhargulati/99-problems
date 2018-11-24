package com.shekhargulati.ninetynine_problems._04_binary_trees;

public class P50 {

    public static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        T id;
        Node<T> left;
        Node<T> right;

        public Node(T id){
            this.id=id;
            this.left=null;
            this.right=null;
        }

        @Override
        public int compareTo(Node<T> object){
            return this.id.compareTo(object.id)>0?1:-1;
        }
    }


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
