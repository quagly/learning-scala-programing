#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#

// create an array of ints of line length
val filesHere = (new java.io.File(".")).listFiles

def fileLines( file: java.io.File) =
  scala.io.Source.fromFile(file).getLines().toArray

def grep(pattern: String) =
  for {
    file <- filesHere
    if file.isFile
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  } yield trimmed.length

// get trimmed length of lines containing "gcd"
val lineLengths = grep(".*gcd.*")

// need more complex structure to store filename, line number, and length
// maybe come back to try it out later
for(len <- lineLengths)
  println(len)
