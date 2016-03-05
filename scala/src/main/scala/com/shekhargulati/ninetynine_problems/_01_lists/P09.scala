package com.shekhargulati.ninetynine_problems._01_lists

import scala.annotation.tailrec

/**
  * <b>(**) Pack consecutive duplicates of list elements into sublists</b>
  * <p>If a list contains repeated elements they should be placed in separate sublists.</p>
  *
  * <pre>
  * pack(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
  * [["a","a","a","a"],["b"],["c","c"],["a","a"],["d"],["e","e","e","e"]]
  * </pre>
  */
object P09 {

  /*
  Using dropWhile and takeWhile
   */
  def pack[T](list: List[T]): List[List[T]] = list match {
    case x :: xs => (x +: xs.takeWhile(el => el == x)) +: pack(xs.dropWhile(el => el == x))
    case Nil => Nil
  }

  /*
  tailrec implementation of the above code
   */
  def pack_tailrecursive[T](list: List[T]): List[List[T]] = {
    @tailrec
    def packR(l: List[T], result: List[List[T]]): List[List[T]] = l match {
      case x :: xs => packR(xs.dropWhile(el => el == x), result :+ (x +: xs.takeWhile(el => el == x)))
      case Nil => result
    }
    packR(list, List())
  }

  /*
  Using in-built function span
   */
  def pack_span[T](list: List[T]): List[List[T]] = list match {
    case x :: xs =>
      val t = xs.span(e => e == x)
      (x +: t._1) +: pack_span(t._2)
    case Nil => Nil
  }

  /*
  Using in-built function span tail rec
   */
  def pack_span_tailrec[T](list: List[T]): List[List[T]] = {
    @tailrec
    def packR(l: List[T], result: List[List[T]]): List[List[T]] = l match {
      case x :: xs =>
        val t = xs.span(e => e == x)
        packR(t._2, result :+ (x +: t._1))
      case Nil => result
    }
    packR(list, List())
  }


}
