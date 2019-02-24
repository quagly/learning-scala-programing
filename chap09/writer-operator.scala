#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
import java.io._
// simple control structure example
// pass in a file name and an operation that prints data
// function will write that data to the file
// this may avoid boilerplate file writing code
def withPrintWriter(file: File, op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close
  }
}

// call function
// pass in file and operation
withPrintWriter(
  new File("date.txt"),
  writer => writer.println(new java.util.Date)
)

// this is the loan patter
// because the control abstration function withPrintWriter()
// loans a resource
// here we loan a PrintWriter to the function op()
//
