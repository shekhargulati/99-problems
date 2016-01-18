package com.shekhargulati.ninetynine_problems.scala.arithmetic

import org.scalatest.{FunSpec, Matchers}

class Problem31Test extends FunSpec with Matchers {

  describe("Problem 29 Spec") {

    it("7 is a prime number") {
      val prime = Problem31.isPrime(7)
      prime should be(true)
    }

    it("10 is not prime number") {
      val prime = Problem31.isPrime(10)
      prime should be(false)
    }
  }

}