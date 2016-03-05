package com.shekhargulati.ninetynine_problems._02_arithmetic

/**
  * (*) Determine whether two positive integer numbers are coprime.
  */
object P38 {

  def coprime(first: Int, second: Int): Boolean = P37.gcd(first, second) == 1

}
