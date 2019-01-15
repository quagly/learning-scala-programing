#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#

// tuples are immutable
val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

