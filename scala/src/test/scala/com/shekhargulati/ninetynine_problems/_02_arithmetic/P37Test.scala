package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P37Test extends FunSpec with Matchers {

  describe("P37 Spec") {
    it("greatest common divisior of 36 and 63 is 9") {
      val result = P37.gcd(36, 63)
      result should be(9)
    }
  }

}