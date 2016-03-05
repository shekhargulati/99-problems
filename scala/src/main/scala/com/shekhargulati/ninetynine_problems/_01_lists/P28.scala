package com.shekhargulati.ninetynine_problems._01_lists

/**
  * (**) Sorting a list of lists according to length of sublists
  */
object P28 {

  /*
  We suppose that a list (InList) contains elements that are lists themselves.
  The objective is to sort the elements of InList according to their length.
  E.g. short lists first, longer lists later, or vice versa
   */
  def lsort[T](list: List[List[T]]): List[List[T]] = list.sortWith((l1, l2) => l1.length - l2.length < 0)

  /*
  Again, we suppose that a list (InList) contains elements that are lists themselves.
  But this time the objective is to sort the elements of InList according to their length frequency;
  i.e. in the default, where sorting is done ascending order, lists with rare lengths are placed first, others with a more frequent length come later.
   */
  def lfsort[T](list: List[List[T]]): List[List[T]] =
    lsort(list)
      .groupBy(l => l.length).values.toList
      .sortWith((l1, l2) => l1.length - l2.length < 0)
      .flatten

}
