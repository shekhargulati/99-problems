package com.shekhargulati.ninetynine_problems._01_lists

import scala.util.Random

/**
  * (**) Extract a given number of randomly selected elements from a list
  */
object P23 {

  /*
  Easy solution by generating a random sequence of numbers.
  This solution may not be ideal as this can produce duplicates
   */
  def randomSelect[T](list: List[T], n: Int): List[T] = {
    val randomSeq = Seq.fill(n)(Random.nextInt(list.size))
    randomSeq.map(r => list(r)).toList
  }

  def randomSelectR[T](list: List[T], n: Int): List[T] = {
    if (n == 0) {
      Nil
    } else {
      val (l, el) = P20.removeAt0(list, Random.nextInt(list.size))
      el :: randomSelectR(l, n - 1)
    }

  }

}
