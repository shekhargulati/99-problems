package com.shekhargulati.ninetynine_problems._01_lists

/**
  * <b>(*) Duplicate the elements of a list</b>
  *
  * {{{
  *     duplicate(List("a", "b", "c", "d"))
  * }}}
  */
object P14 {

  /**
    * Using flatMap
    */
  def duplicate[T](list: List[T]): List[T] = list.flatMap(e => List(e, e))


  /**
    * Using recursion
    */
  def duplicate_recursion[T](list: List[T]): List[T] = list match {
    case x :: xs => x +: x +: duplicate_recursion(xs)
    case Nil => Nil
  }
}
