package com.shekhargulati.ninetynine_problems._01_lists

/**
  * <b>(**) Duplicate the elements of a list a given number of times.</b>
  *
  * {{{
  *   duplicateTimes(List("a", "b", "c"), 3)
  * }}}
  */
object P15 {

  /*
  Using flatMap and List.fill
   */
  def duplicateTimes[T](list: List[T], times: Int): List[T] = list.flatMap(x => List.fill(times)(x))


  /*
  Using recursion
   */
  def duplicateTimes_recursion[T](list: List[T], times: Int): List[T] = list match {
    case x :: xs => List.fill(times)(x) ++ duplicateTimes_recursion(xs, times)
    case Nil => Nil
  }

}
