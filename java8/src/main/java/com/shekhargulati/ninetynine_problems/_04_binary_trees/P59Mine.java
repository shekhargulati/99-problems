package com.shekhargulati.ninetynine_problems._04_binary_trees;

import java.util.ArrayList;
import java.util.List;

public class P59Mine {

    public static class Node<T extends Comparable<T>> implements Comparable<Node<T>>{


        T id;
        Node<T> left;
        Node<T> right;

        public Node(T id){
            this.id=id;
        }

        @Override
        public int compareTo(Node<T> node) {
            if (this.id.compareTo(node.id) > 0) return 1;
            else if (this.id.compareTo(node.id) == 0) return 0;
            else return -1;
        }
    }

    public static Node t(Node root,Node left, Node right){
        if(root==null)  return null;
        root.left=left;
        root.right=right;
        System.out.println((left==null?null:left.id)+"<-------------"+(root==null?null:root.id)+"------------->"+(right==null?null:right.id));
        return root;
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

    public static List<Node> countInternalLeaves(Node root, List<Node> S){
        if(root==null || (root.left==null && root.right==null))   return S;
        S.add(root);
        if(root.left!=null)  S=countInternalLeaves(root.left, S);
        if(root.right!=null) S=countInternalLeaves(root.right,S);
        return S;
    }
    public static void main(String[] args){
        Node root=t(new Node(5),t(new Node(2),new Node(1),new Node(3)),t(new Node(7),new Node(6),new Node(8)));
        System.out.println(isTree(root));
        for(Node<?> node:countInternalLeaves(root,new ArrayList<>()))   System.out.println(node.id);/*
        System.out.println(countInternalLeaves(root, new ArrayList<Node>()));*/
    }
}
