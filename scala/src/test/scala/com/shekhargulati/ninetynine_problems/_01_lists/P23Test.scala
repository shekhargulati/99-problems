package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P23Test extends FunSpec with Matchers {

  describe("P23 Spec") {
    it("should randomly select three elements") {
      val randomElements: List[String] = P23.randomSelect(List("a", "b", "c", "d", "e", "f", "g", "h"), 3)
      randomElements should have length 3
    }
  }

  describe("P23 Spec recursive without duplicates") {
    it("should randomly select three elements") {
      val randomElements: List[String] = P23.randomSelect(List("a", "b", "c", "d", "e", "f", "g", "h"), 3)
      println(randomElements)
      randomElements should have length 3
    }
  }
}