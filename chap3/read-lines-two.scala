#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#
import scala.io.Source

// get the length of the string representation of the charachter count of the input string
def widthOfLength(s: String) = s.length.toString.length

// format for pretty output
if (args.length > 0) {

  // convert iterator to list since this will process
  // every line twice
  var lines = Source.fromFile(args(0)).getLines().toList

  // non-functional way with var
  // we can do better
  var maxWidth = 0
  for (line <- lines)
    maxWidth = maxWidth.max(widthOfLength(line))

  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
}
else
  Console.err.println("Please enter filename")
