#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// like most scala controls
// try-catch-finaly results in a value

import java.net.URL
import java.net.MalformedURLException

// if url does not parse provide default
// note that the def body is a single try expession
def urlFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org")
  }

println(urlFor("badurl"))
