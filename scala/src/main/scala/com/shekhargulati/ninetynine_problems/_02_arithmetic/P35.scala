package com.shekhargulati.ninetynine_problems._02_arithmetic

/**
  * (**) Goldbach's conjecture
  *
  * Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
  * Example: 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct
  * in the general case. It has been numerically confirmed up to very large numbers .
  * Write a predicate to find the two prime numbers that sum up to a given even integer.
  */
object P35 {

  def goldbach(number: Int): List[Int] = number match {
    case 2 => Nil
    case n if isOdd(n) => Nil
    case n => {
      /*
        1. Find all the primes between 2 and number
        2. Start with the max prime number, subtract it from the number
         3. Find the next prime number from the list by searching
         4. If list contains teh number then we found the second one.
         5. Else, go to the next prime number and repeat process
       */
      numbers(number, P34.primeNumbers((2 to number).reverse))
    }
  }

  private def numbers(number: Int, primeNumbers: List[Int]): List[Int] = primeNumbers match {
    case p :: rp if primeNumbers contains (number - p) => List(number - p, p)
    case p :: rp => numbers(number, rp)
    case _ => throw new IllegalArgumentException(s"It should not have happened!!")
  }


  //  {
  //    val result = for (p <- primeNumbers if primeNumbers contains (number - p)) yield List(p, number - p)
  //    result.head
  //  }

  private def isOdd(n: Int): Boolean = {
    n % 2 != 0
  }
}
