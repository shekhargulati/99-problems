package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P31Test extends FunSpec with Matchers {

  describe("Problem 31 Spec") {

    it("7 is a prime number") {
      val prime = P31.isPrime(7)
      prime should be(true)
    }

    it("10 is not prime number") {
      val prime = P31.isPrime(10)
      prime should be(false)
    }
  }

  describe("Problem 31 Spec (trial division)") {
    it("7 is a prime number") {
      val prime = P31.isPrime_trialDivision(7)
      prime should be(true)
    }

    it("10 is not prime number") {
      val prime = P31.isPrime_trialDivision(10)
      prime should be(false)
    }

    it("15,485,863 is last prime below one million") {
      val prime = P31.isPrime_trialDivision(15485863)
      prime should be(true)
    }

    it("86,028,121 is the last prime below five million") {
      val i: Int = 86028121
      val prime = P31.isPrime_trialDivision(86028121)
      prime should be(true)
    }

  }

}