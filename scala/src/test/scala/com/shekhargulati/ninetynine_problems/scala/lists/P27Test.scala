package com.shekhargulati.ninetynine_problems.scala.lists

import org.scalatest.{FunSpec, Matchers}

class P27Test extends FunSpec with Matchers {

  describe("P27 Spec") {
    it("should group 9 person into 3 groups of size 2,3, and 4") {
      val group: List[(List[String], List[String], List[String])] = P27.group3(List("aldo", "beat", "carla", "david", "evi", "flip", "gary", "hugo", "ida"))
      group.foreach(println)
      println(group.size)
      group should have length 1260

    }
  }

}