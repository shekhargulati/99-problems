package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P14Test extends FunSpec with Matchers {

  describe("P14 Spec") {
    it("should duplicate elements in a list") {
      val duplicateList: List[String] = P14.duplicate(List("a", "b", "c", "d"))
      duplicateList should have length 8
      duplicateList should equal(List("a", "a", "b", "b", "c", "c", "d", "d"))
    }
  }

  describe("P14 Spec (recursion)") {
    it("should duplicate elements in a list") {
      val duplicateList: List[String] = P14.duplicate_recursion(List("a", "b", "c", "d"))
      duplicateList should have length 8
      duplicateList should equal(List("a", "a", "b", "b", "c", "c", "d", "d"))
    }
  }


}