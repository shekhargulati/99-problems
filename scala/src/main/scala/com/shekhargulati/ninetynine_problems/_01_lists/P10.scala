package com.shekhargulati.ninetynine_problems._01_lists

/**
  * <b> (*) Run-length encoding of a list.</b>
  * {{{
  *   encode(List("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
  * }}}
  */
object P10 {

  def encode[T](list: List[T]): List[(Int, T)] = {
    P09.pack_span(list).map(l => (l.size, l.head))
  }

}
