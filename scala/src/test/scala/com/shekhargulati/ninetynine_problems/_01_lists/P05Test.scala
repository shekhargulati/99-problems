package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P05Test extends FunSpec with Matchers {

  describe("Reverse a list (built-in)") {
    it("should reverse a list") {
      P05.reverse(List(1, 2, 3, 4, 5)) should equal(List(5, 4, 3, 2, 1))
    }
  }

  describe("Reverse a list (recursive)") {
    it("should reverse a list") {
      P05.reverseRecursive(List(1, 2, 3, 4, 5)) should equal(List(5, 4, 3, 2, 1))
    }
  }

}
