package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P41Test extends FunSpec with Matchers {

  describe("P41 Spec") {
    it("calculate phi of 10090 using P39 solution"){
      val p = P39.totient_phi(10090)
      p should be(4032)
    }

    it("calculate phi of 10090 using P40 solution"){
      val p = P40.phi(10090)
      p should be(4032)
    }
  }

}