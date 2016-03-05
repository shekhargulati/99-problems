package com.shekhargulati.ninetynine_problems._01_lists

import scala.annotation.tailrec

/**
  * <b> (**) Decode a run-length encoded list.</b>
  * {{{
  *   decode(List((4, "a"), "b", (2, "c"), (2, "a"), "d", (4, "e")))
  * }}}
  */
object P12 {

  def decode[T](encoded: List[Any]): List[T] = {
    @tailrec
    def decodeR(encoded: List[Any], result: List[T]): List[T] = encoded match {
      case ((n: Int, e: T) :: xs) => decodeR(xs, result ++ List.fill(n)(e))
      case ((e: T) :: xs) => decodeR(xs, result :+ e)
      case Nil => result
    }
    decodeR(encoded, List())
  }

}
