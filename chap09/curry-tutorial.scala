#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// how to curry

// non-curry addition
// note function take two Int parameters
def plainOldSum(x: Int, y: Int) = x + y
println("plain sum is: " + plainOldSum(1, 2))

// curry addition
// function take two list parameters, each with a single Int
def curriedSum(x: Int)(y: Int) = x + y
println("curried sum is: " + curriedSum(1)(2))

/*
 * What happens is that curriedSum(1) returns a function
 * that adds 1 to the next parameter
 * this is a partially applied function
 * we can get that function so
 */
def addOne = curriedSum(1)_
println("partial function is: " + addOne(2))

