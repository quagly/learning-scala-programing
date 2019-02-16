#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// repeated parameters
// takes any number of string parameters
def echo(args: String*) =
  for (arg <- args) println(arg)

echo()

echo("one")

echo("hello", "world")

// even though String* represents an Array[String]
// an Array[String] cannot be passed
// or type mismatch error
val arr = Array("What's", "up", "doc?")

// compile ERROR
// echo(arr)

// need to use _* syntax to expand Array into it's elements
echo(arr: _*)





