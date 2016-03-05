package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P33Test extends FunSpec with Matchers {

  describe("P33 Spec") {

    it("[[3,2],[5,1],[7,1]] is prime factors multiples of 315") {
      val fs = P33.primeFactorsMult(315)
      fs should be(List((3, 2), (5, 1), (7, 1)))
    }

    it("[[3,1],[11,1]] is prime factors multiples of 33") {
      val fs = P33.primeFactorsMult(33)
      fs should be(List((3, 1), (11, 1)))
    }

  }

}