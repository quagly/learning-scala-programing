#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#

// exists() takes a test as a parameter
def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)

val myInts = List(1,2,3,4)

println(containsOdd(myInts))

