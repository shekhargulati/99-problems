package com.shekhargulati.ninetynine_problems.scala.lists

import org.scalatest.{FunSpec, Matchers}

class P26Test extends FunSpec with Matchers {

  describe("P26 Spec") {
    it("should generate all combinations of size K from N elements of a list") {
      val combinations = P26.combinations(List("a", "b", "c", "d", "e", "f"), 3)
      combinations should have length 20
    }
  }

}