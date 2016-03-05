package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P25Test extends FunSpec with Matchers {

  describe("P25 Spec") {
    it("should generate random permutation of elements of a list") {
      val permutation: List[String] = P25.randomPermutation(List("a", "b", "c", "d", "e", "f"))
      permutation should have length 6
      permutation should contain theSameElementsAs List("a", "b", "c", "d", "e", "f")
    }
  }
}