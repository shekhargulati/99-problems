package com.shekhargulati.ninetynine_problems._02_arithmetic

/**
  * (**) Determine the greatest common divisor of two positive integer numbers.
  */
object P37 {

  def gcd(first: Int, second: Int): Int = (first, second) match {
    case (0, b) => b
    case (a, 0) => a
    case (a, b) if a > b => gcd(a - b, b)
    case (a, b) => gcd(a, b - a)
  }
}
