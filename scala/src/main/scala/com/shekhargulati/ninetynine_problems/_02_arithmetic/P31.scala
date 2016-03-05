package com.shekhargulati.ninetynine_problems._02_arithmetic

/**
  * A prime number is a natural number greater than 1 that is only divisible by 1 and itself. All other numbers are Composite.
  * (**) Determine whether a given integer number is prime.
  */
object P31 {

  def isPrime(number: Int): Boolean =
    if (number < 2)
      false
    else
      !((2 to Math.sqrt(number).toInt) exists (f => number % f == 0))


  /**
    * One of the ways to find a number is prime by finding out all factors of a number below its square root.
    * Give n = a*b, if 1 < a <= b < n, then a <= √n
    *
    * Complexity of this algorithm is O(√n)
    */
  def isPrime_trialDivision(number: Int): Boolean = {
    if (number < 2) {
      throw new IllegalArgumentException("Prime numbers can only be greater than equal to 2")
    } else {
      val factors = for (f <- 2 to Math.sqrt(number).toInt if number % f == 0) yield f
      if (factors.nonEmpty) false else true
    }
  }

}
