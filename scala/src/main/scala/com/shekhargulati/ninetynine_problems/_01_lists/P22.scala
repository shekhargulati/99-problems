package com.shekhargulati.ninetynine_problems._01_lists

import scala.annotation.tailrec

/**
  * (*) Create a list containing all integers within a given range
  */
object P22 {

  def range(start: Int, end: Int): List[Int] = start to end toList

  def rangeR(start: Int, end: Int): List[Int] = {
    @tailrec
    def range(list: List[Int], cur: Int): List[Int] = {
      if (cur <= end) {
        range(list :+ cur, cur + 1)
      } else {
        list
      }
    }

    range(List(), start)
  }

}
