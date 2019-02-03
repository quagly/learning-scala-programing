#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#

val filesHere = (new java.io.File(".")).listFiles
// get filenames in an array using yeild
// note scalaFiles is not var or val
// looks like a Closure but that is chap08
def scalaFiles =
  for {
    file <- filesHere
    if file.isFile
    if file.getName.endsWith(".scala")
  } yield file

for ( file <- scalaFiles )
  println(file)
