package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P18Test extends FunSpec with Matchers {

  describe("P18 Spec") {
    it("should return list between two indexes") {
      val result = P18.slice(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, 7)
      result should have length 5
      result should be(List("c", "d", "e", "f", "g"))
    }
  }

  describe("P18 Spec recursion") {
    it("should return list between two indexes") {
      val result = P18.sliceR(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "k"), 3, 7)
      result should have length 5
      result should be(List("c", "d", "e", "f", "g"))
    }
  }

}