#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

// checked exceptions are not required
// but you can declare them if you like
// using the @throws annotation
// see section 31.2
try {
  val f = new FileReader("input.txt")
  // body of use and close file goes here
} catch {
  case ex: FileNotFoundException => {println("no such file")}
  case ex: IOException => // Handle other I/O error
}

