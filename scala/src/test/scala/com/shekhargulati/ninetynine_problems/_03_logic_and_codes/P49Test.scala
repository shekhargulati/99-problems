package com.shekhargulati.ninetynine_problems._03_logic_and_codes

import org.scalatest.{FunSpec, Matchers}

class P49Test extends FunSpec with Matchers {

  describe("P49 Spec") {
    it("gray code of n=1 is ['0','1']") {
      val graySequence = P49.gray(1)
      graySequence should be(List("0", "1"))
    }

    it("gray code of n=2 is ['00','01','11','10']") {
      val graySequence = P49.gray(2)
      graySequence should be(List("00", "01", "11", "10"))
    }

    it("gray code of n=3 is ['000', '001', '011', '010', '110', '111', '101', '100']") {
      val graySequence = P49.gray(3)
      graySequence should be(List("000", "001", "011", "010", "110", "111", "101", "100"))
    }

  }

}