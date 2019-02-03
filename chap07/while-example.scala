#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -feature "$0" "$@"
!#
// while loops are not functional
// because they return no value
// but may be clearer than a functional approach for some readers
def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b % a
    b = temp
  }
  b
}

// functional recursive alternative without vars
// this is less clear to me, but I can work through it
// recommend challenging every while loop and use of vars
def gcd(x: Long, y: Long): Long =
  if (y == 0) x else gcd( y, x % y)

println(gcdLoop(6,4))
println(gcd(6,4))

