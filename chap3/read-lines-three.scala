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
  val lines = Source.fromFile(args(0)).getLines().toList

  // more functional way with foldLeft and reduce
  // this is the canonical way to operate on every element of a list
  // when reduce is possible
  // return the item with the greatest length in the list
  val longestLine = lines.reduceLeft(
    (a, b) => if (a.length > b.length) a else b
  )
  // get the length of the item with the greatest length
  val maxWidth = widthOfLength(longestLine)

  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
}
else
  Console.err.println("Please enter filename")
