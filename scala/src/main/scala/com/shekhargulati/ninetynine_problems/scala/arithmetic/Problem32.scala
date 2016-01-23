package com.shekhargulati.ninetynine_problems.scala.arithmetic

import scala.collection.mutable

/**
  * (**) Determine the prime factors of a given positive integer.
  */
object Problem32 {

  def primeFactors(number: Int): List[Int] = {
    val factors = mutable.ListBuffer[Int]()
    for (f <- 2 to number / 2 if Problem31.isPrime(f)) {
      var n = number
      while (n % f == 0) {
        n = n / f
        factors.append(f)
      }
    }
    factors.toList
  }

}
