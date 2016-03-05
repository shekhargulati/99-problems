package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P12Test extends FunSpec with Matchers {

  describe("decode spec") {
    it("should decode an run-length encoded list") {
      val decoded: List[String] = P12.decode(List((4, "a"), "b", (2, "c"), (2, "a"), "d", (4, "e")))
      decoded should have length 14
      decoded should equal(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
    }
  }

}