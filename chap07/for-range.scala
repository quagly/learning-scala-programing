#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// print 1 through 4
for (i <- 1 to 4)
  println("Iteration " + i)

println

// print 1 through 3
for (i <- 1 until 4)
  println("Iteration " + i)
