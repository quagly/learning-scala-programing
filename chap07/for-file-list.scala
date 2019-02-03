#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// print files in current directory
// using java.io.File
val filesHere = (new java.io.File(".")).listFiles

// scala can use for on any object that implements forEach() with the appropriate signatures
// see chap 23
// generator syntax
for (file <- filesHere)
  println(file)

