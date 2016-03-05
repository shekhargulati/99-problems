package com.shekhargulati.ninetynine_problems._03_logic_and_codes

import com.shekhargulati.ninetynine_problems._03_logic_and_codes.P46.{and, or}
import org.scalatest.{FunSpec, Matchers}

class P46Test extends FunSpec with Matchers {

  describe("P46 Spec") {
    it("should generate truth table of a given logical expression") {
      val tableContents = P46.table((a: Boolean, b: Boolean) => and(a, or(a, b)))
      val result = """A          B          result
                     |true       true       true
                     |true       false      true
                     |false      true       false
                     |false      false      false
                     |""".stripMargin

      tableContents should be(result)
    }
  }
}