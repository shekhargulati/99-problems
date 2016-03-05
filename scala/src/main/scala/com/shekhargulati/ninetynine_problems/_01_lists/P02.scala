package com.shekhargulati.ninetynine_problems._01_lists

object P02 {

  def secondLast[T](list: List[T]): T = list match {
    case x :: (_ :: Nil) => x
    case x :: xs => secondLast(xs)
    case _ => throw new NoSuchElementException("Can't find secondLast element from a list with less than 2 elements")
  }

  def secondLast1[T](list: List[T]): T = if (list.isEmpty) throw new NoSuchElementException else list.init.last

}
