package com.shekhargulati.ninetynine_problems._01_lists

/**
  * <b>(**) Flatten a nested list structure</b>
  * <p>
  * Transform a list, possibly holding lists as elements into a 'flat' list by replacing each list with its elements (recursively).
  * </p>
  */
object P07 {

  def flatten(list: List[Any]): List[Any] = {
    var result = List[Any]()
    for (el <- list) {
      el match {
        case xs: List[Any] =>
          result = result ++: flatten(xs)
        case _ =>
          result = result :+ el
      }
    }
    result
  }

  def flatten_flatMap(list: List[Any]): List[Any] = list.flatMap(el => el match {
    case xs: List[Any] => flatten_flatMap(xs)
    case _ => List(el)
  })

}
