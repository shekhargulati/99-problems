package com.shekhargulati.ninetynine_problems._03_logic_and_codes

import org.scalatest.{FunSpec, Matchers}

class P50Test extends FunSpec with Matchers {

  describe("P50Spec"){
    it("should generate huffman code"){
      val code = P50.huffman(List(("1", 5), ("2", 7), ("3", 10), ("4", 15), ("5", 20), ("6", 45)))

    }
  }

}