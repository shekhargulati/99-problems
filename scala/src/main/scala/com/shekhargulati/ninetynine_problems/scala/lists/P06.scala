package com.shekhargulati.ninetynine_problems.scala.lists

/**
  * Find out whether a list is a palindrome
  */
object P06 {

  def isPalindrome[T](list: List[T]): Boolean = {
    P05.reverse(list) == list
  }

  def isPalindrome_reverseRecursive[T](list: List[T]): Boolean = {
    P05.reverseRecursive(list) == list
  }


}
