package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P09Test extends FunSpec with Matchers {

  describe("Pack a list spec") {
    it("should pack unique elements in their own list") {
      val list = List("a", "b", "c")
      val packedList: List[List[String]] = P09.pack(list)
      packedList should have size 3
      packedList(0) should equal(List("a"))
      packedList(1) should equal(List("b"))
      packedList(2) should equal(List("c"))
    }

    it("should pack duplicates in their own list") {
      val list = List("a", "a", "b", "b", "b", "c", "d", "d")
      val packedList: List[List[String]] = P09.pack(list)
      packedList should have size 4
      packedList(0) should equal(List("a", "a"))
      packedList(1) should equal(List("b", "b", "b"))
      packedList(2) should equal(List("c"))
      packedList(3) should equal(List("d", "d"))
    }

    it("should pack only consecutive duplicates in their own list") {
      val list = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
      val packedList: List[List[String]] = P09.pack(list)
      packedList should have size 6
      packedList(0) should equal(List("a", "a", "a", "a"))
      packedList(1) should equal(List("b"))
      packedList(2) should equal(List("c", "c"))
      packedList(3) should equal(List("a", "a"))
      packedList(4) should equal(List("d"))
      packedList(5) should equal(List("e", "e", "e", "e"))
    }

  }

  describe("Pack a list spec(tailrec)") {
    it("should pack unique elements in their own list") {
      val list = List("a", "b", "c")
      val packedList: List[List[String]] = P09.pack_tailrecursive(list)
      packedList should have size 3
      packedList(0) should equal(List("a"))
      packedList(1) should equal(List("b"))
      packedList(2) should equal(List("c"))
    }

    it("should pack duplicates in their own list") {
      val list = List("a", "a", "b", "b", "b", "c", "d", "d")
      val packedList: List[List[String]] = P09.pack_tailrecursive(list)
      packedList should have size 4
      packedList(0) should equal(List("a", "a"))
      packedList(1) should equal(List("b", "b", "b"))
      packedList(2) should equal(List("c"))
      packedList(3) should equal(List("d", "d"))
    }

    it("should pack only consecutive duplicates in their own list") {
      val list = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
      val packedList: List[List[String]] = P09.pack_tailrecursive(list)
      packedList should have size 6
      packedList(0) should equal(List("a", "a", "a", "a"))
      packedList(1) should equal(List("b"))
      packedList(2) should equal(List("c", "c"))
      packedList(3) should equal(List("a", "a"))
      packedList(4) should equal(List("d"))
      packedList(5) should equal(List("e", "e", "e", "e"))
    }

  }

  describe("Pack a list spec(span)") {
    it("should pack unique elements in their own list") {
      val list = List("a", "b", "c")
      val packedList: List[List[String]] = P09.pack_span(list)
      packedList should have size 3
      packedList(0) should equal(List("a"))
      packedList(1) should equal(List("b"))
      packedList(2) should equal(List("c"))
    }

    it("should pack duplicates in their own list") {
      val list = List("a", "a", "b", "b", "b", "c", "d", "d")
      val packedList: List[List[String]] = P09.pack_span(list)
      packedList should have size 4
      packedList(0) should equal(List("a", "a"))
      packedList(1) should equal(List("b", "b", "b"))
      packedList(2) should equal(List("c"))
      packedList(3) should equal(List("d", "d"))
    }

    it("should pack only consecutive duplicates in their own list") {
      val list = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
      val packedList: List[List[String]] = P09.pack_span(list)
      packedList should have size 6
      packedList(0) should equal(List("a", "a", "a", "a"))
      packedList(1) should equal(List("b"))
      packedList(2) should equal(List("c", "c"))
      packedList(3) should equal(List("a", "a"))
      packedList(4) should equal(List("d"))
      packedList(5) should equal(List("e", "e", "e", "e"))
    }

  }

  describe("Pack a list spec(span tailrec)") {
    it("should pack unique elements in their own list") {
      val list = List("a", "b", "c")
      val packedList: List[List[String]] = P09.pack_span_tailrec(list)
      packedList should have size 3
      packedList(0) should equal(List("a"))
      packedList(1) should equal(List("b"))
      packedList(2) should equal(List("c"))
    }

    it("should pack duplicates in their own list") {
      val list = List("a", "a", "b", "b", "b", "c", "d", "d")
      val packedList: List[List[String]] = P09.pack_span_tailrec(list)
      packedList should have size 4
      packedList(0) should equal(List("a", "a"))
      packedList(1) should equal(List("b", "b", "b"))
      packedList(2) should equal(List("c"))
      packedList(3) should equal(List("d", "d"))
    }

    it("should pack only consecutive duplicates in their own list") {
      val list = List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e")
      val packedList: List[List[String]] = P09.pack_span_tailrec(list)
      packedList should have size 6
      packedList(0) should equal(List("a", "a", "a", "a"))
      packedList(1) should equal(List("b"))
      packedList(2) should equal(List("c", "c"))
      packedList(3) should equal(List("a", "a"))
      packedList(4) should equal(List("d"))
      packedList(5) should equal(List("e", "e", "e", "e"))
    }

  }

}