package com.shekhargulati.ninetynine_problems._03_logic_and_codes

/**
  * 3.01 (**) Truth tables for logical expressions.
  *
  * Define predicates and/2, or/2, nand/2, nor/2, xor/2, impl/2 and equ/2 (for logical equivalence) which succeed or fail according to the result of their respective operations; e.g. and(A,B) will succeed, if and only if both A and B succeed. Note that A and B can be Prolog goals (not only the constants true and fail).
  *
  * A logical expression in two variables can then be written in prefix notation, as in the following example: and(or(A,B),nand(A,B)).
  * Now, write a predicate table/3 which prints the truth table of a given logical expression in two variables.
  */
object P46 {

  def table(f: (Boolean, Boolean) => Boolean): String = {
    val tableBuilder = StringBuilder.newBuilder
    tableBuilder.append("A          B          result\n")
    for {a <- List(true, false)
         b <- List(true, false)
    } {
      tableBuilder.append(f"$a%-10s $b%-10s ${f(a, b)}%s\n")
    }
    tableBuilder.mkString("")
  }

  def or(a: Boolean, b: Boolean): Boolean = a || b

  def and(a: Boolean, b: Boolean): Boolean = a && b

  def nand(a: Boolean, b: Boolean) = !and(a, b)
}
