package com.shekhargulati.ninetynine_problems._01_lists

import scala.annotation.tailrec
import scala.collection.mutable

/**
  * (*) Insert an element at a given position into a list
  */
object P21 {

  def insertAt[T](list: List[T], pos: Int, t: T): List[T] = {
    if (pos < 1) {
      throw new IllegalArgumentException("position should be greater than 0")
    }
    val (first, second) = list.splitAt(pos - 1)
    (first :+ t) ++ second
  }

  def insertAt_inbuilt[T](list: List[T], pos: Int, t: T): List[T] = {
    if (pos < 1) {
      throw new IllegalArgumentException("position should be greater than 0")
    }
    val listBuffer: mutable.Buffer[T] = list.toBuffer
    listBuffer.insert(pos - 1, t)
    listBuffer.toList
  }

  def insertAt_recursion[T](list: List[T], pos: Int, t: T): List[T] = {
    @tailrec
    def insertAt(remaining: List[T], first: List[T], cur: Int): List[T] = remaining match {
      case xs if cur == pos => (first :+ t) ++ remaining
      case x :: xs => insertAt(xs, first :+ x, cur + 1)
      case _ => Nil
    }
    insertAt(list, List(), 1)
  }

}
