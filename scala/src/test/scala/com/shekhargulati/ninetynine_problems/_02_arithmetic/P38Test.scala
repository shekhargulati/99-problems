package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P38Test extends FunSpec with Matchers {

  describe("P38 Spec") {
    it("35 and 64 are coprime") {
      val coprime: Boolean = P38.coprime(35, 64)
      coprime should be(true)
    }
  }

}