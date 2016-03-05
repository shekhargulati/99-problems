package com.shekhargulati.ninetynine_problems._01_lists

import org.scalatest.{FunSpec, Matchers}

class P27Test extends FunSpec with Matchers {

  describe("P27 Spec part a") {
    it("should group 9 person into 3 groups of size 2,3, and 4") {
      val group = P27.group3(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"))
      group should have length 1260
    }
  }

  describe("P27 Spec part a second approach") {
    it("should group 9 person into 3 groups of size 2,3, and 4") {
      val group = P27.group3_1(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"))
      group should have length 1260
    }
  }

  describe("P27 Spec part b") {
    it("should group 9 person into 3 groups of size 2,3, and 4") {
      val group: List[List[String]] = P27.group(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"), List(2, 3, 4))
      group should have length 1260
    }

    it("should group 9 person into 3 groups of size 2,2, and 5") {
      val group: List[List[String]] = P27.group(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"), List(2, 2, 5))
      group should have length 756
    }
  }

  describe("P27 Spec part b second approach") {

    it("should group 3 person into 2 groups of size 1 and 2") {
      val group: List[List[String]] = P27.group_1(List("a", "b", "c"), List(1, 2))
      group should have length 3
    }


    it("should group 9 person into 3 groups of size 2,3, and 4") {
      val group: List[List[String]] = P27.group_1(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"), List(2, 3, 4))
      group should have length 1260
    }

    it("should group 9 person into 3 groups of size 2,2, and 5") {
      val group: List[List[String]] = P27.group_1(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"), List(2, 2, 5))
      group should have length 756
    }
  }

}