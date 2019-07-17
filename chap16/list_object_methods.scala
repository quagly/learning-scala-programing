#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

// 16.8 List object methods
// object rather than class so globally accessible

// List.range
// creating a range of numbers
println(List.range(1, 5))
println(List.range(1, 9, 2))
println(List.range(9, 1, -3))

// List.fill
// creating a uniform list
// create copies of the same element
println(List.fill(5)('a))
println(List.fill(3)("hello"))

// multi-dimenensional
println(List.fill(2, 3)('b'))

// List.tabulate
// Tabulating a funciton
// create a list by computing a function
// works like list.fill usinga function rather than a literal
val squares = List.tabulate(5)(n => n * n)
println(squares)
val multiplication = List.tabulate(5, 5)(_ * _)
println(multiplication)

// List.concat
// concatenate Lists
println(List.concat(List('a', 'b'), List('c')))
println(List.concat(List(), List('b'), List('c')))
println(List.concat())
