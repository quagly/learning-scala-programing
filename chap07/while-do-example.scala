#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// prints standard input
// until empty line entered

/*
 * Code in book uses deprecated readLine
 * warning: method readLine in trait DeprecatedPredef is deprecated (since 2.11.0): use the method in `scala.io.StdIn
 * need to add import to not use Predef version of readLine
 */
import scala.io.StdIn.readLine

var line = ""
do {
  line = readLine()
  println("Read: " + line)
} while (line != "")
