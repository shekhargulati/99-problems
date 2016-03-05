package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P24Test extends FunSpec with Matchers {

  describe("P24 Spec") {
    it("should give 6 random number between 1 and 49") {
      val randomList: List[Int] = P24.randomSelect(6, (1, 49))
      randomList should have length 6
      println(randomList) // One possible output List(18, 47, 6, 43, 48, 38)
    }
  }

}