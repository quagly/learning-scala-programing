#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#
// Scala lists are immutable
val oneTwo = List(1, 2)
val threeFour = List(3, 4)
// list concatenation
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus "  + oneTwoThreeFour + " is a new list.")


