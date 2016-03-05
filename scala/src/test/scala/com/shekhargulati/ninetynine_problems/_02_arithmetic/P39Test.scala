package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P39Test extends FunSpec with Matchers {

  describe("P39 Spec"){
    it("10 has 4 Euler totient"){
      val phi = P39.totient_phi(10)
      phi should be(4)
    }

    it("9 has 6 Euler totient"){
      val phi = P39.totient_phi(9)
      phi should be(6)
    }

    it("6 has 2 Euler totient"){
      val phi = P39.totient_phi(6)
      phi should be(2)
    }

    it("6 has 4 cototient"){
      val c = P39.cototient(6)
      c should be(4)
    }

  }

}