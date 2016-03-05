package com.shekhargulati.ninetynine_problems._03_logic_and_codes

/**
  * (***) Huffman code.
  */
object P50 {

  class Tree[T](data: (Int, T), left: Tree[T], right: Tree[T])

  def huffman(fs: List[(String, Int)]): List[(String, String)] = {
    val sortedFs = fs.sortBy { case (_, f) => f }
    println(sortedFs)

    val firstTwoElements: List[(String, Int)] = sortedFs.take(2)
    val tree: Tree[String] = new Tree((firstTwoElements.map(_._2).sum, "*"), new Tree[String](firstTwoElements.head.swap, null, null), new Tree[String](firstTwoElements.last.swap, null, null))

    sortedFs.drop(2)

    ???
  }
}
