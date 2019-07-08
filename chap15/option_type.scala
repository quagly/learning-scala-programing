#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
/* 15.6 option type pattern matches
 *
 */

// when getting from a map the return is option type
// either Some value or None
val capitals =
  Map("France" -> "Paris", "Japan" -> "Tokyo")

// Some
println(capitals get "France")

// None
println(capitals get "North Pole")

// the most common way to take optional values apart is
// with a pattern match
def show(x: Option[String]) = x match {
  case Some(s) => s
  case None => "?"
}

println(show(capitals get "France"))
println(show(capitals get "North Pole"))
