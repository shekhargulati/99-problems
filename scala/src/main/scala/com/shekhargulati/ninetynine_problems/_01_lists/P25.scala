package com.shekhargulati.ninetynine_problems._01_lists

/**
  * (*) Generate a random permutation of the elements of a list.
  */
object P25 {

  def randomPermutation[T](list: List[T]): List[T] = P23.randomSelectR(list, list.size)
}
