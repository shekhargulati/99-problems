package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P04Test extends FunSpec with Matchers {

  describe("size of a list (built-in)") {
    it("should be zero when list is empty") {
      P04.length(List()) should be(0)
    }

    it("should be 5 when list has five elements") {
      P04.length(List(1, 2, 3, 4, 5)) should be(5)
    }
  }

  describe("size of a list (built-in another)") {
    it("should be zero when list is empty") {
      P04.length1(List()) should be(0)
    }

    it("should be 5 when list has five elements") {
      P04.length1(List(1, 2, 3, 4, 5)) should be(5)
    }
  }

  describe("size of a list (recursive)") {
    it("should be zero when list is empty") {
      P04.lengthRecursive(List()) should be(0)
    }

    it("should be 5 when list has five elements") {
      P04.lengthRecursive(List(1, 2, 3, 4, 5)) should be(5)
    }
  }

}
