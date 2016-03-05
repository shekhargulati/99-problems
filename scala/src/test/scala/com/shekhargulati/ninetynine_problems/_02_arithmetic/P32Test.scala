package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P32Test extends FunSpec with Matchers {

  describe("Problem 32 Spec") {

    it("[2,2,2] are prime factors of 8") {
      val fs = P32.primeFactors(8)
      fs should be(List(2, 2, 2))
    }

    it("[2,2,3] are prime factors of 12") {
      val fs = P32.primeFactors(12)
      fs should be(List(2, 2, 3))
    }

    it("[3,3,5,7] are prime factors of 315") {
      val fs = P32.primeFactors(315)
      fs should be(List(3, 3, 5, 7))
    }

    it("[3,11] are prime factors of 33") {
      val fs = P32.primeFactors(33)
      fs should be(List(3, 11))
    }
  }
}