package com.shekhargulati.ninetynine_problems._01_lists

/**
  * (**) Generate the combinations of K distinct objects chosen from the N elements of a list
  */
object P26 {

  /**
    * Using built-in <b>combinations</b> function
    */
  def combinations[T](list: List[T], k: Int): List[List[T]] = list.combinations(k).toList

  def combinations1[T](list: List[T], k: Int): List[List[T]] = {
    list match {
      case x :: xs if k == 1 => list.map(List(_))
      case x :: xs => combinations1(xs, k - 1).map(x :: _) ::: combinations1(xs, k)
      case Nil => Nil
    }
  }

}
