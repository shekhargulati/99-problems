package com.shekhargulati.ninetynine_problems._02_arithmetic

/**
  * (**) Calculate Euler's totient function phi(m) (2).
  */
object P40 {

  def phi(m: Int): Int = {
    P33.primeFactorsMult(m).map { case (p1, m1) => (p1 - 1) * Math.pow(p1, m1 - 1) }.product.toInt
  }

}
