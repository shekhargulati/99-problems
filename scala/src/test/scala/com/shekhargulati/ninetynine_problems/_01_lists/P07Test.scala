package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P07Test extends FunSpec with Matchers {

  describe("flatten a list spec (for-each)") {

    it("should return empty list when flatten an empty list") {
      val flatten: List[Any] = P07.flatten(List())
      flatten shouldBe List()
    }

    it("should flatten nested lists") {
      val flatten: List[Any] = P07.flatten(List("a", List("b", List("c", "d")), "e"))
      flatten should have size 5
      flatten should be(List("a", "b", "c", "d", "e"))
    }

    it("should flatten deep nested lists") {
      val flatten: List[Any] = P07.flatten(List("a", List("b", List("c", List("d", List("e", List("f", "g"))))), "h"))
      flatten should have size 8
      flatten should be(List("a", "b", "c", "d", "e", "f", "g", "h"))
    }

    it("should return same list when no nested list is given") {
      val flatten: List[Any] = P07.flatten(List("a", "b", "c", "d", "e"))
      flatten should have size 5
      flatten should be(List("a", "b", "c", "d", "e"))
    }
  }

  describe("flatten a list spec (flatMap)") {

    it("should return empty list when flatten an empty list") {
      val flatten: List[Any] = P07.flatten_flatMap(List())
      flatten shouldBe List()
    }

    it("should flatten nested lists") {
      val flatten: List[Any] = P07.flatten_flatMap(List("a", List("b", List("c", "d")), "e"))
      flatten should have size 5
      flatten should be(List("a", "b", "c", "d", "e"))
    }

    it("should flatten deep nested lists") {
      val flatten: List[Any] = P07.flatten_flatMap(List("a", List("b", List("c", List("d", List("e", List("f", "g"))))), "h"))
      flatten should have size 8
      flatten should be(List("a", "b", "c", "d", "e", "f", "g", "h"))
    }

    it("should return same list when no nested list is given") {
      val flatten: List[Any] = P07.flatten_flatMap(List("a", "b", "c", "d", "e"))
      flatten should have size 5
      flatten should be(List("a", "b", "c", "d", "e"))
    }
  }
}