package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P28Test extends FunSpec with Matchers {

  describe("P28Spec") {

    it("should sort list elements by length") {
      val input = List(List("a", "b", "c"), List("d", "e"), List("f", "g", "h"), List("d", "e"), List("i", "j", "k"), List("m", "n"), List("o"))
      val result = P28.lsort(input)
      result should be(List(List("o"), List("d", "e"), List("d", "e"), List("m", "n"), List("a", "b", "c"), List("f", "g", "h"), List("i", "j", "k")))
    }

    it("should sort list by length frequency") {
      val input = List(List("a", "b", "c"), List("d", "e"), List("f", "g", "h"), List("d", "e"), List("i", "j", "k", "l"), List("m", "n"), List("o"))
      val result = P28.lfsort(input)
      result should be(List(List("i", "j", "k", "l"), List("o"), List("a", "b", "c"), List("f", "g", "h"), List("d", "e"), List("d", "e"), List("m", "n")))
    }

    it("should sort list by element list length frequency") {
      val input = List(List("a", "b", "c", "d"), List("d", "e"), List("f", "g", "h"), List("d", "e"), List("i", "j", "k", "l"), List("m", "n"), List("o"))
      val result = P28.lfsort(input)
      result should be(List(List("o"), List("f", "g", "h"), List("a", "b", "c", "d"), List("i", "j", "k", "l"), List("d", "e"), List("d", "e"), List("m", "n")))
    }

  }

}