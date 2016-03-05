package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P11Test extends FunSpec with Matchers {

  describe("encode-modified spec") {
    it("should apply modified run-length on list") {
      val encodedList: List[Any] = P11.encode_modified(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
      encodedList should have size 6
      encodedList(0) should equal((4, "a"))
      encodedList(1) should equal("b")
      encodedList(2) should equal((2, "c"))
      encodedList(3) should equal((2, "a"))
      encodedList(4) should equal("d")
      encodedList(5) should equal((4, "e"))
    }
  }

}