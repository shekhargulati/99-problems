package com.shekhargulati.ninetynine_problems._01_lists


/**
  * (**) Drop every N'th element from a list
  * {{{
  *     dropEveryNth(List("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"), 3)
  * }}}
  */
object P16 {

  /*
  n is one based.
   */
  def dropEveryNth[T](list: List[T], n: Int): List[T] = {
    if (n == 0) {
      list
    } else {
      list.zipWithIndex.withFilter(t => if ((t._2 + 1) % n == 0) false else true).map(_._1)
    }
  }

  def dropEveryNth_recursive[T](list: List[T], n: Int): List[T] = {
    def drop(list: List[T], n: Int, index: Int): List[T] = {
      list match {
        case x :: xs if index % n != 0 => x +: drop(xs, n, index + 1)
        case x :: xs if index % n == 0 => drop(xs, n, index + 1)
        case _ => Nil
      }
    }

    if (n == 0) list else drop(list, n, 1)
  }

}
