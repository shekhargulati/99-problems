package com.shekhargulati.random

import java.time.{LocalDate, Month}

import org.scalatest.{FunSpec, Matchers}

class MovieSchedulerTest extends FunSpec with Matchers {

  describe("MovieScheduler Spec") {

    it("should schedule all non-overlapping movies within the duration") {
      val movie1 = Movie("Movie 1", LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2016, Month.JUNE, 30))
      val movie2 = Movie("Movie 2", LocalDate.of(2016, Month.JULY, 1), LocalDate.of(2016, Month.DECEMBER, 31))
      val movies = List(movie1, movie2)

      val scheduledMovies = MovieScheduler.schedule(movies, (LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2016, Month.DECEMBER, 31)))

      scheduledMovies should have length 2
      scheduledMovies(0) should be(movie1)
      scheduledMovies(1) should be(movie2)
    }

    it("should return empty list when no movie can be scheduled in the duration") {
      val movie1 = Movie("Movie 1", LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2017, Month.JUNE, 30))
      val movie2 = Movie("Movie 2", LocalDate.of(2016, Month.JULY, 1), LocalDate.of(2017, Month.DECEMBER, 31))
      val movies = List(movie1, movie2)

      val scheduledMovies = MovieScheduler.schedule(movies, (LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2016, Month.DECEMBER, 31)))

      scheduledMovies should be('empty)
    }


    it("should schedule only non-overlapping movies within the duration") {
      val movie1 = Movie("Movie 1", LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2016, Month.JUNE, 30))
      val movie2 = Movie("Movie 2", LocalDate.of(2016, Month.JULY, 1), LocalDate.of(2016, Month.DECEMBER, 31))
      val movie3 = Movie("Movie 3", LocalDate.of(2016, Month.APRIL, 1), LocalDate.of(2016, Month.OCTOBER, 31))
      val movies = List(movie1, movie2, movie3)

      val scheduledMovies = MovieScheduler.schedule(movies, (LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2016, Month.DECEMBER, 31)))

      scheduledMovies should have length 2
      scheduledMovies(0) should be(movie1)
      scheduledMovies(1) should be(movie2)
    }

    it("should schedule only non-overlapping movies with multiple overlapping movies") {
      val movie1 = Movie("Movie 1", LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2016, Month.MARCH, 31))
      val movie2 = Movie("Movie 2", LocalDate.of(2016, Month.FEBRUARY, 1), LocalDate.of(2016, Month.MARCH, 30))
      val movie3 = Movie("Movie 3", LocalDate.of(2016, Month.MARCH, 20), LocalDate.of(2016, Month.JULY, 31))
      val movie4 = Movie("Movie 4", LocalDate.of(2016, Month.APRIL, 1), LocalDate.of(2016, Month.JULY, 31))
      val movie5 = Movie("Movie 5", LocalDate.of(2016, Month.APRIL, 30), LocalDate.of(2016, Month.JUNE, 30))
      val movie6 = Movie("Movie 6", LocalDate.of(2016, Month.SEPTEMBER, 1), LocalDate.of(2016, Month.SEPTEMBER, 30))
      val movie7 = Movie("Movie 7", LocalDate.of(2016, Month.SEPTEMBER, 1), LocalDate.of(2016, Month.OCTOBER, 31))
      val movie8 = Movie("Movie 8", LocalDate.of(2016, Month.OCTOBER, 1), LocalDate.of(2016, Month.NOVEMBER, 1))
      val movie9 = Movie("Movie 9", LocalDate.of(2016, Month.APRIL, 1), LocalDate.of(2016, Month.NOVEMBER, 30))
      val movie10 = Movie("Movie 10", LocalDate.of(2016, Month.DECEMBER, 1), LocalDate.of(2016, Month.DECEMBER, 31))

      val movies = List(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10)

      val scheduledMovies = MovieScheduler.schedule(movies, (LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2016, Month.DECEMBER, 31)))

      scheduledMovies should have length 5
      scheduledMovies(0) should be(movie2)
      scheduledMovies(1) should be(movie5)
      scheduledMovies(2) should be(movie6)
      scheduledMovies(3) should be(movie8)
      scheduledMovies(4) should be(movie10)
    }

  }
}
