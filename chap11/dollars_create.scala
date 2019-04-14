#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
val money = new Dollars(1000000)
// val parameter can be accessed as a field
println(s"printing money.amount parameter as Int ${money.amount}")
println(s"printing money object as Dollars ${money}")


