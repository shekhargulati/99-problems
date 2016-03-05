package com.shekhargulati.ninetynine_problems._02_arithmetic

import scala.collection.mutable

/**
  * (**) Determine the prime factors of a given positive integer.
  */
object P32 {

  def primeFactors(number: Int): List[Int] = {
    val factors = mutable.ListBuffer[Int]()
    for (f <- 2 to number / 2 if P31.isPrime(f)) {
      var n = number
      while (n % f == 0) {
        n = n / f
        factors.append(f)
      }
    }
    factors.toList
  }

}
