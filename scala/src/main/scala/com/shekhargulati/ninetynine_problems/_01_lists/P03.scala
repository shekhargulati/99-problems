package com.shekhargulati.ninetynine_problems._01_lists

/**
  * Find the K'th element of a list.
  *
  * The first element of a list has index 0
  */
object P03 {

  def kth[T](list: List[T], k: Int): T = list(k)

  def kth1[T](list: List[T], k: Int): T = list.take(k + 1).last

  def kthRecursive[T](list: List[T], k: Int): T = list match {
    case x :: xs if k == 0 => x
    case x :: xs => kthRecursive(xs, k - 1)
    case _ => throw new NoSuchElementException
  }


}
