package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P20Test extends FunSpec with Matchers {

  describe("P20 spec") {
    it("should remove kth element from a list") {
      val result = P20.removeAt(List("a", "b", "c", "d"), 2)
      result._1 should equal(List("a", "c", "d"))
      result._2 should equal("b")
    }
  }


  describe("P20 spec 0 based") {
    it("should remove kth element from a list") {
      val result = P20.removeAt0(List("a", "b", "c", "d"), 1)
      result._1 should equal(List("a", "c", "d"))
      result._2 should equal("b")
    }
  }


  describe("P20 spec splitAt") {
    it("should remove kth element from a list") {
      val result = P20.removeAt_splitAt(List("a", "b", "c", "d"), 2)
      result._1 should equal(List("a", "c", "d"))
      result._2 should equal("b")
    }
  }
}