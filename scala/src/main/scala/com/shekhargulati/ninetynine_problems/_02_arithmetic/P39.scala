package com.shekhargulati.ninetynine_problems._02_arithmetic

/**
  * 2.09 (**) Calculate Euler's totient function phi(m).
  */
object P39 {

  def totient_phi(m: Int): Int = (1 to m).count(r => P38.coprime(m, r))


  /**
    * The cototient of n is defined as n – φ(n), i.e. the number of positive integers less than or equal to n that are divisible by at least one prime that also divides n.
    *
    * @param m number
    * @return cototient
    */
  def cototient(m: Int): Int = m - totient_phi(m)

}
