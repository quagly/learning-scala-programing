#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
val le = new LineElement("hello")
println(s"le width is: ${le.width}")
println(s"le height is: ${le.height}")

