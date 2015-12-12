package com.shekhargulati.ninetynine_problems.scala.lists

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


  def pack[T](list: List[T]): List[List[T]] = {
    list match {
      case x :: xs => (x +: xs.takeWhile(el => el == x)) +: pack(xs.dropWhile(el => el == x))
      case Nil => Nil
    }
  }

}
