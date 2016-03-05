package com.shekhargulati.random

/**
  * You are given two list of sizes n and m where n >> m i.e n is much bigger than m.
  * You have to find the fastest way to find intersection between n and m.
  *
  * Possible problem: You have a big list of valid account numbers and a small list of fraud accounts and your job is to find
  * if there are any valid accounts in the fraud list.
  */
object RandomProblem01 {

  def intersection[T](nList: Vector[T], mList: Vector[T]): Vector[T] = {
    /*
    1. Sort the mList
    2. Iterate over nList and for each element do a binary search in the mList
    3. If else is found, then add to the result list
    4. Else skip the element
    5. Return the result list
     */
    //    for (el <- nList if mList.sorted.contains(el)) yield {
    //      el
    //    }
    ???
  }
}
