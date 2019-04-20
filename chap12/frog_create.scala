#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
// trait example
val frog = new Frog
println(frog.philosophize)

// traits are types
val phil: Philosophical = frog
println(phil.philosophize)

// trait with superclass
val phrog: Philosophical = new FrogExtends
println(phrog.philosophize)

