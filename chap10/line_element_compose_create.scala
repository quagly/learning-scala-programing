#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
val lec = new LineElementCompose("a string of stuff")
println(s"lec width is: ${lec.width}")
println(s"lec height is: ${lec.height}")

