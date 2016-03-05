package com.shekhargulati.ninetynine_problems._01_lists

import scala.annotation.tailrec

/**
  * Reverse a list
  */
object P05 {

  def reverse[T](list: List[T]): List[T] = list.reverse

  def reverseRecursive[T](list: List[T]): List[T] = {
    @tailrec
    def tail(src: List[T], dest: List[T]): List[T] = src match {
      case Nil => dest
      case x :: xs => tail(xs, x +: dest)
    }
    tail(list, List())
  }

}
