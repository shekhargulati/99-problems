package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P19Test extends FunSpec with Matchers {

  describe("P19 Spec") {
    it("should make head last element and second element from left as head") {
      val rotated = P19.rotate(List("a", "b", "c", "d", "e", "f", "g", "h"), 1)
      rotated.head should equal("b")
      rotated.last should equal("a")
    }

    it("should return same list when n is 0") {
      val rotated = P19.rotate(List("a", "b", "c", "d", "e", "f", "g", "h"), 0)
      rotated should be(List("a", "b", "c", "d", "e", "f", "g", "h"))
    }

    it("should rotate list by three elements") {
      val rotated = P19.rotate(List("a", "b", "c", "d", "e", "f", "g", "h"), 3)
      rotated should be(List("d", "e", "f", "g", "h", "a", "b", "c"))
    }

    it("should rotate when n is negative") {
      val rotated = P19.rotate(List("a", "b", "c", "d", "e", "f", "g", "h"), -2)
      rotated should be(List("g", "h", "a", "b", "c", "d", "e", "f"))
    }
  }

  describe("P19 Spec recursive") {
    it("should make head last element and second element from left as head") {
      val rotated = P19.rotateR(List("a", "b", "c", "d", "e", "f", "g", "h"), 1)
      rotated.head should equal("b")
      rotated.last should equal("a")
    }

    it("should return same list when n is 0") {
      val rotated = P19.rotateR(List("a", "b", "c", "d", "e", "f", "g", "h"), 0)
      rotated should be(List("a", "b", "c", "d", "e", "f", "g", "h"))
    }

    it("should rotate list by three elements") {
      val rotated = P19.rotateR(List("a", "b", "c", "d", "e", "f", "g", "h"), 3)
      rotated should be(List("d", "e", "f", "g", "h", "a", "b", "c"))
    }

    it("should rotate when n is negative") {
      val rotated = P19.rotateR(List("a", "b", "c", "d", "e", "f", "g", "h"), -2)
      rotated should be(List("g", "h", "a", "b", "c", "d", "e", "f"))
    }
  }


}