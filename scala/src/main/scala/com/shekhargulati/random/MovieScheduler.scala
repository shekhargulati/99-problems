package com.shekhargulati.random

import java.time.LocalDate

object MovieScheduler {


  /**
    * Find non-overlapping movies that actor can do within a duration
    */
  def schedule(movies: List[Movie], duration: (LocalDate, LocalDate)): List[Movie] = {
    /*
    1. Find the movie which completes first within the duration
    2. Add that to the result list
    3. Call the method recursively by remove movie found in step 2. Also, set start of duration to the completion date of that movie
     */
    val selectedOpt = movies
      .filter(m => m.start.isAfter(duration._1.minusDays(1)) && m.completion.isBefore(duration._2.plusDays(1)))
      .sortWith({
        case (m1, m2) => m1.completion.isBefore(m2.completion)
      })
      .headOption

    selectedOpt.map(selected => {
      movies.splitAt(movies.indexOf(selected) + 1) match {
        case (Nil, second) => List(selected) ++ schedule(second, (selected.completion, duration._2))
        case (first, second) => List(selected) ++ schedule(first.init ++ second, (selected.completion, duration._2))
        case _ => Nil
      }
    }).getOrElse(Nil)
  }

}

case class Movie(title: String, start: LocalDate, completion: LocalDate)
