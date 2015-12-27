package com.shekhargulati.ninetynine_problems.scala.lists

/**
  * (**) Generate the combinations of K distinct objects chosen from the N elements of a list
  */
object P26 {

  /**
  Using built-in <b>combinations</b> function
    */
  def combinations[T](list: List[T], k: Int): List[List[T]] = list.combinations(k).toList

}
