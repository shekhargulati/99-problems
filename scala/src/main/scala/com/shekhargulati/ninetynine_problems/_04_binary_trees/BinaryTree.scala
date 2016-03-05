package com.shekhargulati.ninetynine_problems._04_binary_trees

/*
  A binary tree is either empty or it is composed of a root element and two successors,
  which are binary trees themselves.
 */
case class BinaryTree[+T](x: T, left: BinaryTree[T], right: BinaryTree[T])