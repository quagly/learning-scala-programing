#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
val ae = new ArrayElement(Array("hello", "world"))
println(s"ae width is: ${ae.width}")
println(s"ae height is: ${ae.height}")

val aeo = new ArrayElementOverride(Array("hello", "world"))
println(s"aeo width is: ${aeo.width}")
println(s"aeo height is: ${aeo.height}")

val aep = new ArrayElementParametric(Array("hello", "world"))
println(s"aep width is: ${aep.width}")
println(s"aep height is: ${aep.height}")
