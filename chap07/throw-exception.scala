#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// example of throwing an exception using if/else
// does scala like checked exceptions?

val n = 3

// interesting approach where throw is a value of type Nothing
// so the if expression returns a value, but the Nothing value is never
// assigned because an exception is thrown
// Type nothing is discussed in section 11.3
val half =
  if (n % 2 == 0)
    n / 2
  else
    throw new RuntimeException("n must be even")

println(half)


