package com.shekhargulati.ninetynine_problems._01_lists

import scala.annotation.tailrec

/**
  * <b> (**) Run-length encoding of a list (direct solution).</b>
  *
  * {{{
  *   encode_direct([a,a,a,a,b,c,c,a,a,d,e,e,e,e]).
  * }}}
  */
object P13 {

  /**
    * Using dropWhile method and tail recursion
    */
  def encode_direct[T](list: List[T]): List[Any] = {
    @tailrec
    def encode(list: List[T], result: List[Any]): List[Any] = list match {
      case x :: xs =>
        val remaining = xs.dropWhile(_ == x)
        val duplicateCount: Int = list.length - remaining.length
        duplicateCount match {
          case 1 => encode(remaining, result :+ x)
          case _ => encode(remaining, result :+(duplicateCount, x))
        }
      case Nil =>
        result
    }
    encode(list, List())
  }

  def encode_direct_span[T](list: List[T]): List[Any] = list match {
    case x :: xs =>
      val (consecutiveDuplicates, remaining) = xs.span(_ == x)
      (consecutiveDuplicates.length + 1, x) +: encode_direct_span(remaining)
    case Nil => Nil
  }


}
