package com.shekhargulati.ninetynine_problems._01_lists

import java.util.NoSuchElementException

import org.scalatest.{FunSpec, Matchers}

class P02Test extends FunSpec with Matchers {

  describe("SecondLast Element in a List Spec") {
    it("should give first element when list has only two elements") {
      val numbers = List(10, 6)
      P02.secondLast(numbers) should be(10)
    }

    it("should give second last element when list has more than two elements") {
      val numbers = List(1, 2, 11, 4, 5, 8, 10, 6)
      P02.secondLast(numbers) should be(10)
    }

    it("should throw exception when list is empty") {
      val thrown = the[NoSuchElementException] thrownBy P02.secondLast(List())
      thrown.getMessage should equal("Can't find secondLast element from a list with less than 2 elements")
    }

    it("should throw exception when list has one element") {
      val thrown = the[NoSuchElementException] thrownBy P02.secondLast(List(1))
      thrown.getMessage should equal("Can't find secondLast element from a list with less than 2 elements")
    }
  }

}
