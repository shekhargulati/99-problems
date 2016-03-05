package com.shekhargulati.ninetynine_problems._01_lists

/**
  * <b>(*) Modified run-length encoding</b>
  * <p>
  * Modify the result of problem 1.10 in such a way that if an element has no duplicates it is simply copied into the result list.
  * Only elements with duplicates are transferred as [N,E] terms.
  * </p>
  * {{{
  *   encode_modified(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
  * }}}
  *
  */
object P11 {

  def encode_modified[T](list: List[T]): List[Any] = {
    P09.pack_span(list).map(ll => ll match {
      case x :: Nil => x
      case x :: xs => (ll.length, x)
      case Nil => Nil
    })
  }

}
