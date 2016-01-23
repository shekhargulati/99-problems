package com.shekhargulati.ninetynine_problems.scala.arithmetic

import com.shekhargulati.ninetynine_problems.scala.lists.P10

/**
  * (**) Determine the prime factors of a given positive integer (2)
  */
object P33 {

  def primeFactorsMult(number: Int): List[(Int, Int)] = P10.encode(P32.primeFactors(number)).map { case (t1, t2) => (t2, t1) }

}
