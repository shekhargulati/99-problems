package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P26Test extends FunSpec with Matchers {

  describe("P26 Spec") {
    it("should generate all combinations of size K from N elements of a list") {
      val combinations = P26.combinations(List("a", "b", "c", "d", "e", "f"), 3)
      println(combinations)
      combinations should have length 20
    }
  }


  describe("P26 Spec recursive") {
    it("should generate all combinations of size K from N elements of a list") {
      val combinations = P26.combinations1(List("a", "b", "c", "d", "e", "f"), 3)
      println(combinations)
      combinations should have length 20
    }

    it("should generate all combinations of size 2 from 3 elements of a list") {
      val combinations = P26.combinations1(List("a", "b", "c"), 2)
      println(combinations)
      combinations should have length 3
    }

    it("should generate all combinations of size 3 from 3 elements of a list") {
      val combinations = P26.combinations1(List("a", "b", "c"), 3)
      println(combinations)
      combinations should have length 1
    }
  }

}