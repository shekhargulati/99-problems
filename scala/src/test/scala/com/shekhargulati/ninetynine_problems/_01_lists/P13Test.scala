package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P13Test extends FunSpec with Matchers {

  describe("P13 Spec") {
    it("should perform run-length encoding") {
      val encodedList: List[Any] = P13.encode_direct(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
      encodedList should have size 6
      encodedList(0) should equal((4, "a"))
      encodedList(1) should equal("b")
      encodedList(2) should equal((2, "c"))
      encodedList(3) should equal((2, "a"))
      encodedList(4) should equal("d")
      encodedList(5) should equal((4, "e"))
    }
  }

  describe("P13 Spec(span)") {
    it("should perform run-length encoding") {
      val encodedList: List[Any] = P13.encode_direct_span(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
      encodedList should have size 6
      encodedList(0) should equal((4, "a"))
      encodedList(1) should equal(1, "b")
      encodedList(2) should equal((2, "c"))
      encodedList(3) should equal((2, "a"))
      encodedList(4) should equal(1, "d")
      encodedList(5) should equal((4, "e"))
    }
  }


}