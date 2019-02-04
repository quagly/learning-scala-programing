#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#

// this show a java patten
// scala also has the "loan pattern"
// see section 9.4
import java.io.FileReader

val file = new FileReader("input.txt")
try {
  // use file
} finally {
  // for single line try or finally brackets are not required
  file.close() // always close the file
}

