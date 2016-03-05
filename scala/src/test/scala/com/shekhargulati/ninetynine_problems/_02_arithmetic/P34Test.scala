package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P34Test extends FunSpec with Matchers {

  describe("P34 Spec") {
    it("should list 2,3,5,7 as prime numbers between 0 and 10") {
      val primeNumbers = P34.primeNumbers(0 to 10)
      primeNumbers should have length 4
      primeNumbers should be(List(2, 3, 5, 7))
    }

    it("should list 7, 11, 13, 17, 19, 23, 29, 31 as prime numbers between 7 and 31") {
      val primeNumbers = P34.primeNumbers(7 to 31)
      primeNumbers should have length 8
      primeNumbers should be(List(7, 11, 13, 17, 19, 23, 29, 31))
    }

  }

  describe("P34 Spec sieve") {
    it("should list 2,3,5,7 as prime numbers between 0 and 10") {
      val primeNumbers = P34.primeNumbers_sieve(0 to 10)
      primeNumbers should have length 4
      primeNumbers should be(List(2, 3, 5, 7))
    }

    it("should list 7, 11, 13, 17, 19, 23, 29, 31 as prime numbers between 7 and 31") {
      val primeNumbers = P34.primeNumbers_sieve(7 to 31)
      primeNumbers should have length 8
      primeNumbers should be(List(7, 11, 13, 17, 19, 23, 29, 31))
    }

  }

}