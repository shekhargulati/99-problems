package com.shekhargulati.ninetynine_problems._01_lists

/**
  * Find the number of elements of a list
  */
object P04 {

  def length[T](list: List[T]): Int = list.size

  def length1[T](list: List[T]): Int = list.map(_ => 1).sum

  def lengthRecursive[T](list: List[T]): Int = {
    def rec(list: List[T], length: Int): Int = list match {
      case x :: xs => rec(xs, length + 1)
      case Nil => length
    }
    rec(list, 0)
  }

}
