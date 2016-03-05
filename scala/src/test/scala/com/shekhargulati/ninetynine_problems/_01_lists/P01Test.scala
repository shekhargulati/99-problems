package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P01Test extends FunSpec with Matchers {

  describe("P01 List builtin method") {
    it("should find last element") {
      val last = P01.last(List("a", "b", "c", "d"))
      last should be("d")
    }
  }

  describe("P01 List recursive method") {
    it("should find last element") {
      val last = P01.lastRecursion(List("a", "b", "c", "d"))
      last should be("d")
    }
  }

}
