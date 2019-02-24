#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// section 9.5 describes by-name parameters
// but they are not named so not sure why they are called that

// regualer without byName assert example
// that support not asserting parameter

var assertionsEnabled = true

def myAssert(predicate: () => Boolean) =
  if (assertionsEnabled && !predicate())
    throw new AssertionError


myAssert(() => 5 > 3)

// having to pass in
// () => 5 > 3
// is unnatural
// we can remove the () from predictate using by name parameters
// no () in the parameter definition or in the call to predicate
def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

byNameAssert(5 > 3)

/*
 * A critical that we pass a function rather than a boolean
 * a boolean will be evaluated before the call to the function
 * this is a problem is we want to disable the assertion as the
 * evaluation itself may error
 * by passing a predicate evaluation is delayed until the predicate
 * is calling inside the function
 */
assertionsEnabled = false

// division by zero will not throw exception because it is never evaluated
val x = 5
byNameAssert( x / 0 == 0 )



