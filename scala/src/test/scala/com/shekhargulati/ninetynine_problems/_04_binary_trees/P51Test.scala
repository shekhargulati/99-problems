package com.shekhargulati.ninetynine_problems._04_binary_trees

import org.scalatest.{FunSpec, Matchers}

class P51Test extends FunSpec with Matchers {

  describe("Tree") {
    it("is a binary tree if it is empty") {
      P51.isTree(null) should be(true)
    }

    it("is a binary tree if it only consists on root node") {
      P51.isTree(BinaryTree(1, null, null)) should be(true)
    }

    it("is a binary tree if it consists of root node and left and right nodes") {
      P51.isTree(BinaryTree(3, BinaryTree(2, null, null), BinaryTree(5, null, null))) should be(true)
    }
  }

}