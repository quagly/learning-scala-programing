#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// scala does not include a break command to exit a loop prematurely
// but does have a break objects
// this is considered poor functional style

// break throw an exception which is caught by breakable
// this means that breakable just needs to be in scope
// don't have to set breakable for every breaking method

// print "?" until empty line
import scala.util.control.Breaks._
import java.io._

val in = new BufferedReader(new InputStreamReader(System.in))

// mark block as breakable
breakable {
  while(true) {
    println("? ")
    if (in.readLine() == "") break
  }
}




