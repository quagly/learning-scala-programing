#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#
// wild way to run scala script from docker container
// code goes here
println("Hello, " + args(0) + "!")
