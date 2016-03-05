package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P21Test extends FunSpec with Matchers {

  describe("P21 Spec") {
    it("should insert element at the second position") {
      val result = P21.insertAt(List("a", "b", "c", "d"), 2, "alfa")
      result should have length 5
      result should be(List("a", "alfa", "b", "c", "d"))
    }


    it("should insert element at the zeroth position") {
      val result = P21.insertAt(List("a", "b", "c", "d"), 1, "alfa")
      result should have length 5
      result should be(List("alfa", "a", "b", "c", "d"))
    }

    it("should insert element at the end position") {
      val result = P21.insertAt(List("a", "b", "c", "d"), 5, "alfa")
      result should have length 5
      result should be(List("a", "b", "c", "d", "alfa"))
    }
  }


  describe("P21 Spec ListBuffer insert") {
    it("should insert element at the second position") {
      val result = P21.insertAt_inbuilt(List("a", "b", "c", "d"), 2, "alfa")
      result should have length 5
      result should be(List("a", "alfa", "b", "c", "d"))
    }


    it("should insert element at the zeroth position") {
      val result = P21.insertAt_inbuilt(List("a", "b", "c", "d"), 1, "alfa")
      result should have length 5
      result should be(List("alfa", "a", "b", "c", "d"))
    }

    it("should insert element at the end position") {
      val result = P21.insertAt_inbuilt(List("a", "b", "c", "d"), 5, "alfa")
      result should have length 5
      result should be(List("a", "b", "c", "d", "alfa"))
    }
  }

  describe("P21 Spec recursion") {
    it("should insert element at the second position") {
      val result = P21.insertAt_recursion(List("a", "b", "c", "d"), 2, "alfa")
      result should have length 5
      result should be(List("a", "alfa", "b", "c", "d"))
    }


    it("should insert element at the zeroth position") {
      val result = P21.insertAt_recursion(List("a", "b", "c", "d"), 1, "alfa")
      result should have length 5
      result should be(List("alfa", "a", "b", "c", "d"))
    }

    it("should insert element at the end position") {
      val result = P21.insertAt_recursion(List("a", "b", "c", "d"), 5, "alfa")
      result should have length 5
      result should be(List("a", "b", "c", "d", "alfa"))
    }
  }

}