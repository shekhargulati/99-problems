package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P10Test extends FunSpec with Matchers {

  describe("encode a list spec") {
    it("should encode consecutive duplicate elements") {
      val list = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
      val encodedList: List[(Int, String)] = P10.encode(list)
      encodedList should have size 6
      encodedList(0) should equal((4, "a"))
      encodedList(1) should equal((1, "b"))
      encodedList(2) should equal((2, "c"))
      encodedList(3) should equal((2, "a"))
      encodedList(4) should equal((1, "d"))
      encodedList(5) should equal((4, "e"))
    }
  }

}