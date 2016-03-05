package com.shekhargulati.ninetynine_problems._02_arithmetic

/**
  * (*) A list of prime numbers.
  */
object P34 {

  def primeNumbers(range: Range): List[Int] = range.filter(number => P31.isPrime(number)).toList

  def primeNumbers_sieve(range: Range): List[Int] = {
    val start = 2
    val numbers = start to range.last

    def p(numbers: List[Int]): List[Int] = numbers match {
      case n :: remaining => n +: p(remaining.filter(_ % n != 0))
      case _ => Nil
    }
    p(numbers.toList).filter(_ >= range.head)
  }

}
