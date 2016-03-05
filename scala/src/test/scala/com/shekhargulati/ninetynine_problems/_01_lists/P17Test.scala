package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P17Test extends FunSpec with Matchers {

  describe("P17 Spec") {

    it("should split into two halves by length") {
      val (first, second) = P17.split(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3)
      first should have length 3
      first should be(List("a", "b", "c"))
      second should have length 7
      second should be(List("d", "e", "f", "g", "h", "i", "k"))
    }

    it("should split into two halves by length with size 0 and list size when n is 0") {
      val (first, second) = P17.split(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 0)
      first should have length 0
      first should be(List())
      second should have length 10
      second should be(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"))
    }
  }

  describe("P17 Spec take-drop") {

    it("should split into two halves by length") {
      val (first, second) = P17.split_take_drop(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3)
      first should have length 3
      first should be(List("a", "b", "c"))
      second should have length 7
      second should be(List("d", "e", "f", "g", "h", "i", "k"))
    }

    it("should split into two halves by length with size 0 and list size when n is 0") {
      val (first, second) = P17.split_take_drop(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 0)
      first should have length 0
      first should be(List())
      second should have length 10
      second should be(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"))
    }
  }

}