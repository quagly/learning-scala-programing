#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
// note single quotes for literal Char
val ue = new UniformElement('h', 10, 10)
println(s"ue width is: ${ue.width}")
println(s"ue height is: ${ue.height}")

