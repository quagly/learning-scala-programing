#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#
/*
 * see page 43
 * an "operator" is a method that acts on the left operand
 * unless the method ends in a colon in which case it acts on the right operand
 */

// "cons" method :: prepends a list
val twoThree = List(2, 3)
// equivalant to twoThree.::(1)
val oneTwoThree = 1 :: twoThree
println(oneTwoThree)

// trick to initialize a list
// make Nil the last element and call prepend on it
// Nil is the empty list.  Equivalant to List()
val onTwThr = 1 :: 2 :: 3 :: Nil
println(onTwThr)


