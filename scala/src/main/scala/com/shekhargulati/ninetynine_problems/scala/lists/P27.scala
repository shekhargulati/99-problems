package com.shekhargulati.ninetynine_problems.scala.lists

/**
  * (**) Group the elements of a set into disjoint subsets
  */
object P27 {

  /**
    * In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons?
    * Write a predicate that generates all the possibilities via backtracking.
    *
    */
  def group3[T](list: List[T]): List[(List[T], List[T], List[T])] = {
    /*
    1. Find all the combinations of 2,3,4
    2. Then for each combination of 2 find combination of 3 and 4 with no same element
    3. Add all of them to a list
     */

    val groupWith2 = P26.combinations(list, 2)
    val groupWith3 = P26.combinations(list, 3)
    val groupWith4 = P26.combinations(list, 4)

    groupWith2
      .flatMap(xs =>
        groupWith3.filterNot(xs3 => xs3.exists(e => xs.contains(e))).map(xs3 => (xs, xs3)))
      .flatMap(xs23 =>
        groupWith4.filterNot(xs4 => xs4.exists(e => xs23._1.contains(e)) || xs4.exists(e => xs23._2.contains(e)))
          .map(xs4 => (xs23._1, xs23._2, xs4)))
  }
}
