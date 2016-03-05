package com.shekhargulati.tadm.ch03

/**
  * Write a program to reverse the direction of a given singly-linked list.
  * In other words, after the reversal all pointers should now point backwards. Your algorithm should take linear time.
  */
object Problem3_2 {

  def reverse[T](list: List[T]): List[T] = list match {
    case head :: tail => reverse(tail) :+ head
    case _ => Nil
  }

  def main(args: Array[String]) {
    val numbers = List(1, 2, 3)
    println(reverse(numbers))

  }
}
