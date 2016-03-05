package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P35Test extends FunSpec with Matchers {

  describe("P35 Spec") {
    it("8 is the sum of 5 and 3 prime numbers") {
      val numbers = P35.goldbach(8)
      numbers should have length 2
      numbers should be(List(3, 5))
    }

    it("4 is the sum of 2 and 2 prime numbers") {
      val numbers = P35.goldbach(4)
      numbers should have length 2
      numbers should be(List(2, 2))
    }

    it("28 is the sum of 5 and 23 prime numbers") {
      val numbers = P35.goldbach(28)
      numbers should have length 2
      numbers should be(List(5, 23))
    }

  }

}