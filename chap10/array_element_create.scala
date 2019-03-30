#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
val ae = new ArrayElement(Array("hello", "world"))
println(s"width is: ${ae.width}")
println(s"height is: ${ae.height}")

val aeo = new ArrayElementOverride(Array("hello", "world"))
println(s"width is: ${aeo.width}")
println(s"height is: ${aeo.height}")
