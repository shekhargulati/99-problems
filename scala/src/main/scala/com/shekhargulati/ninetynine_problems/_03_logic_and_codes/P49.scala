package com.shekhargulati.ninetynine_problems._03_logic_and_codes

/**
  * (**) Gray code.
  * An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
  * n = 1: C(1) = ['0','1'].
  * n = 2: C(2) = ['00','01','11','10'].
  * n = 3: C(3) = ['000','001','011','010','110','111','101','100'].
  */
object P49 {


  def gray(n: Int): List[String] = {
    /*
    Algorithm:
     1. Start with a gray code sequence of n-1
     2. Reverse the list
     3. Concatenate original and reverse lists
     4. Prepend original list with 0 and reverse list with 1
     */
    if (n == 1) {
      List("0", "1")
    } else {
      val original = gray(n - 1)
      val reversed = original.reverse
      original.map("0" + _) ++ reversed.map("1" + _)
    }
  }


  def binarySeries(n: Int): List[String] = n match {
    case 1 => List("0", "1")
    case _ => List("0", "1").flatMap(x => binarySeries(n - 1).map(x + _))
  }

}
