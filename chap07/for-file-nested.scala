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
    // optimization, store the trimmed line instead of trimming twice
    // once for pattern and once for print
    // this is called "mid stream assignement ina for expression
    // trimmed is a val but no declaration required
    trimmed = line.trim
    if trimmed.matches(pattern)
  } println(file + ": " + trimmed)

// print all lines containing string "gcd" in .scala files
grep(".*gcd.*")
