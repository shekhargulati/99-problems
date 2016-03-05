package com.shekhargulati.ninetynine_problems._01_lists

import java.util.NoSuchElementException

object P01 {

  /*
  Using the built in last function of a list
   */
  def last[T](list: List[T]): T = list.last

  /*
  Using recursion we ignore the first element until we have a list with only one element
   */
  def lastRecursion[T](list: List[T]): T = list match {
    case x :: Nil => x
    case _ :: xs => lastRecursion(xs)
    case _ => throw new NoSuchElementException("list is empty")
  }


}