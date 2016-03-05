package com.shekhargulati.ninetynine_problems._02_arithmetic

/**
  * (**) A list of Goldbach compositions.
  */
object P36 {

  def goldbach_list(range: Range): List[(Int, (Int, Int))] = {
    range.filter(_ % 2 == 0).filter(_ > 2).map(even => {
      val g = P35.goldbach(even)
      (even, (g.head, g.last))
    }).toList
  }

  def goldbach_list1(range: Range, gt: Int): List[(Int, (Int, Int))] = {
    goldbach_list(range).filter(g => g._2._1 > gt && g._2._2 > gt)
  }


}
