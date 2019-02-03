#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#

// prints lines in scala files
val filesHere = (new java.io.File(".")).listFiles

def fileLines( file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toArray
// note semi-colon for explicit end-of-expression
// after endsWith(".scala")
// if for is using parens ()
// so using brackets {}
// scala infers semi-colons when in brackets but not parens
def grep(pattern: String) =
  for {
    file <- filesHere
    if file.isFile
    if file.getName.endsWith(".scala")

    line <- fileLines(file)
    if line.trim.matches(pattern)
  } println(file + ": " + line.trim)

// print all lines containing string "gcd" in .scala files
grep(".*gcd.*")

