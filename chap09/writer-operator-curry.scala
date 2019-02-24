#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
import java.io._
// extend simple example to use currying
// to make it use look more like a built-in
// by using {} instead of () for parameters
// {} is allowed anywhere there is only one parameter
//
// two parameter lists instead of one
def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close
  }
}

// pull out the file parameter for currying
val dateFile = new File("date.txt")

// partially applied function provides a single parameter function
// so can use curly braces for the op parameter
withPrintWriter(dateFile) {
  writer => writer.println(new java.util.Date)
}
