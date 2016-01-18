package com.shekhargulati.ninetynine_problems.scala.arithmetic

/**
  * (**) Determine whether a given integer number is prime.
  */
object Problem31 {

  def isPrime(number: Int): Boolean =
    if (number < 2)
      throw new IllegalArgumentException(s"$number should be greater than 1")
    else
      !((2 to Math.sqrt(number).toInt) exists (n => number % n == 0))

}
