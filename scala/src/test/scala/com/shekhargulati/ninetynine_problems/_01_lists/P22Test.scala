package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P22Test extends FunSpec with Matchers {

  describe("P22 Spec") {
    it("should give a range between 4 to 9 both inclusive") {
      val range: List[Int] = P22.range(4, 9)
      range should have length 6
      range should be(List(4, 5, 6, 7, 8, 9))
    }
  }

  describe("P22 Spec recursive") {
    it("should give a range between 4 to 9 both inclusive") {
      val range: List[Int] = P22.rangeR(4, 9)
      range should have length 6
      range should be(List(4, 5, 6, 7, 8, 9))
    }
  }

}