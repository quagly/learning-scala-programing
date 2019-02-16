#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// default parameter of console output
def printTime(out: java.io.PrintStream = (Console.out)) =
  out.println("time " +  System.currentTimeMillis())

// default to Console.out
printTime()

printTime(Console.err)

// default parameters work nicely with named parameters
// since any parameter can be passed and defaults used for the rest
def printTime2(out: java.io.PrintStream = (Console.out),
               divisor: Int = 1) =
  out.println("time " +  System.currentTimeMillis()/divisor)

printTime2()

printTime2(Console.err)

printTime2(divisor = 1000)
