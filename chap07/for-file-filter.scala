#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#

val filesHere = (new java.io.File(".")).listFiles

for (file <- filesHere
     if file.isFile
     if file.getName.endsWith(".scala")
) println(file)

