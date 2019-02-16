#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
def speed(distance: Float, time: Float): Float =
  distance / time

println(speed(100, 10))

println(speed(distance = 100, time = 10))
