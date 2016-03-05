package com.shekhargulati.ninetynine_problems._02_arithmetic

import org.scalatest.{FunSpec, Matchers}

class P36Test extends FunSpec with Matchers {

  describe("P36 Spec") {
    it("should produce a list of goldbach compositions") {
      val goldaCompositions = P36.goldbach_list(9 to 20)
      goldaCompositions should have length 6
      goldaCompositions should be(List((10, (3, 7)), (12, (5, 7)), (14, (3, 11)), (16, (3, 13)), (18, (5, 13)), (20, (3, 17))))
    }

    it("should produce a list of goldbach compositions where both primes are greater than 50") {
      val goldaCompositions = P36.goldbach_list1(1 to 2000, 50)
      goldaCompositions should have length 4
      goldaCompositions should be(List((992, (73, 919)), (1382, (61, 1321)), (1856, (67, 1789)), (1928, (61, 1867))))
    }
  }

}