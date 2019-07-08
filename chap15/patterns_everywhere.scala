#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
/* 15.7 patterns everywhere
 * outside of match expressions
 */

// patterns in variable definition
val myTuple = (123, "abc")

val (number, string) = myTuple

println("number is " + number)
println("string is " + string)

// same idea can be applied to case classes
val exp = BinOp("*", Number(5), Number(1))
// where is this variable?  Not understanding this line
val BinOp(op, left, right) = exp

// skip case sequences as partial functions

// patterns in for expressions
val capitals =
  Map("France" -> "Paris", "Japan" -> "Tokyo")

// this works because the map always has pairs
// so there is always a match
for ((country, city) <- capitals)
  println("The capital of " + country + " is " + city)

// what if there is not a match? use option
val results = List(Some("apple"), None, Some("orange"))
// only match some
// whatever does not match the pattern is discarded
for (Some(fruit) <- results) println(fruit)



