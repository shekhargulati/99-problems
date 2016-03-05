package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P08Test extends FunSpec with Matchers {

  describe("compress list spec") {

    it("should remove consecutive duplicates in a list") {
      val compressedList: List[String] = P08.compress(List("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"))
      compressedList should have size 5
      compressedList should be(List("a", "b", "c", "d", "e"))
    }

    it("should not remove non consecutive duplicates in a list") {
      val compressedList: List[String] = P08.compress(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
      compressedList should have size 6
      compressedList should be(List("a", "b", "c", "a", "d", "e"))
    }
  }

  describe("compress list spec (dropWhile)") {

    it("should remove consecutive duplicates in a list") {
      val compressedList: List[String] = P08.compress_dropWhile(List("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"))
      compressedList should have size 5
      compressedList should be(List("a", "b", "c", "d", "e"))
    }

    it("should not remove non consecutive duplicates in a list") {
      val compressedList: List[String] = P08.compress_dropWhile(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
      compressedList should have size 6
      compressedList should be(List("a", "b", "c", "a", "d", "e"))
    }
  }

  describe("compress list spec (dropWhile tailrec)") {

    it("should remove consecutive duplicates in a list") {
      val compressedList: List[String] = P08.compress_dropWhile_tailrec(List("a", "a", "a", "a", "b", "c", "c", "d", "e", "e", "e", "e"))
      compressedList should have size 5
      compressedList should be(List("a", "b", "c", "d", "e"))
    }

    it("should not remove non consecutive duplicates in a list") {
      val compressedList: List[String] = P08.compress_dropWhile_tailrec(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
      compressedList should have size 6
      compressedList should be(List("a", "b", "c", "a", "d", "e"))
    }
  }

}