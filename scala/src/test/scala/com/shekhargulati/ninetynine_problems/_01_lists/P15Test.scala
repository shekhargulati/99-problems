package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P15Test extends FunSpec with Matchers {

  describe("P15 Spec") {
    it("should duplicate N times elements of a list") {
      val duplicates: List[String] = P15.duplicateTimes(List("a", "b", "c"), 3)
      duplicates should have length 9
      duplicates should equal(List("a", "a", "a", "b", "b", "b", "c", "c", "c"))
    }
  }

  describe("P15 Spec recursion") {
    it("should duplicate N times elements of a list") {
      val duplicates: List[String] = P15.duplicateTimes_recursion(List("a", "b", "c"), 3)
      duplicates should have length 9
      duplicates should equal(List("a", "a", "a", "b", "b", "b", "c", "c", "c"))
    }
  }

}