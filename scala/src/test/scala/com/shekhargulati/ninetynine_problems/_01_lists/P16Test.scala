package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P16Test extends FunSpec with Matchers {

  describe("P16 Spec") {
    it("should remove every third item in the list") {
      val result = P16.dropEveryNth(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3)
      result should have length 8
      result should be(List("a", "b", "d", "e", "g", "h", "j", "k"))
    }

    it("should return same list when list has less items than n ") {
      val result = P16.dropEveryNth(List("a", "b"), 3)
      result should have length 2
      result should be(List("a", "b"))
    }

    it("should return same list when n is 0") {
      val result = P16.dropEveryNth(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0)
      result should have length 11
      result should be(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"))
    }
  }

  describe("P16 Spec recursive") {
    it("should remove every third item in the list") {
      val result = P16.dropEveryNth_recursive(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3)
      result should have length 8
      result should be(List("a", "b", "d", "e", "g", "h", "j", "k"))
    }

    it("should return same list when list has less items than n ") {
      val result = P16.dropEveryNth_recursive(List("a", "b"), 3)
      result should have length 2
      result should be(List("a", "b"))
    }

    it("should return same list when n is 0") {
      val result = P16.dropEveryNth_recursive(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 0)
      result should have length 11
      result should be(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"))
    }
  }

}