package com.shekhargulati.ninetynine_problems._01_lists

import scala.annotation.tailrec

/**
  * (**) Rotate a list N places to the left
  */
object P19 {

  /*
  Using split function defined in P17
   */
  def rotate[T](list: List[T], n: Int): List[T] = {
    val (first, second) = P17.split(list, makeNPositive(list, n))
    second ++: first
  }

  /*
    Using recursion
     */
  def rotateR[T](list: List[T], n: Int): List[T] = {
    @tailrec
    def rotate(list: List[T], result: List[T], cur: Int, n: Int): List[T] = list match {
      case x :: xs if cur < n => rotate(xs, result :+ x, cur + 1, n)
      case l => l ++ result
    }
    rotate(list, List(), 0, makeNPositive(list, n))
  }

  private def makeNPositive[T](list: List[T], n: Int): Int = if (n < 0) list.length + n else n


}
