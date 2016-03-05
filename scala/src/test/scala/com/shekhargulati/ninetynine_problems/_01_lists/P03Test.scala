package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P03Test extends FunSpec with Matchers {

  describe("kth element of a list (built-in)") {
    it("should be first element when k is 0") {
      P03.kth(List(1, 2, 3, 4, 5), 0) should be(1)
    }

    it("should be last element when k is equal to size of list minus one") {
      P03.kth(List(1, 2, 3, 4, 5), 4) should be(5)
    }

    it("should be (k+1)th element") {
      P03.kth(List(1, 2, 3, 4, 5), 2) should be(3)
    }
  }

  describe("kth element of a list (built-in another)") {
    it("should be first element when k is 0") {
      P03.kth1(List(1, 2, 3, 4, 5), 0) should be(1)
    }

    it("should be last element when k is equal to size of list minus one") {
      P03.kth1(List(1, 2, 3, 4, 5), 4) should be(5)
    }

    it("should be (k+1)th element") {
      P03.kth1(List(1, 2, 3, 4, 5), 2) should be(3)
    }
  }

  describe("kth element of a list (recursive)") {
    it("should be first element when k is 0") {
      P03.kthRecursive(List(1, 2, 3, 4, 5), 0) should be(1)
    }

    it("should be last element when k is equal to size of list minus 1") {
      P03.kthRecursive(List(1, 2, 3, 4, 5), 4) should be(5)
    }

    it("should be (k+1)th element") {
      P03.kthRecursive(List(1, 2, 3, 4, 5), 2) should be(3)
    }
  }
}
