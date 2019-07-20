#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

import scala.collection.mutable

/* 17.3 immutable vs mutable
 *
 *
 */

// immutable var vs val

// val cannot "append"
// val people = Set("Nancy", "Jane")
// vals cannot use +=
// people += "Bob"

// but immutable var will create new when append it tried
var people = Set("Nancy", "Jane")
people += "Bob"
println(people)

// this works with any method ending in "="
people -= "Jane"
people ++= List("Tom", "Harry")
println(people)





