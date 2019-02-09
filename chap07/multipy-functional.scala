#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// print out multiplication table using functional approach

// get a sequence of numbers with string padding
def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }

// converts sequence to string
def makeRow(row: Int) = makeRowSeq(row).mkString

// return table as string
// one row per line
def multiTable() = {

  val tableSeq =  // a sequence of row strings
    for (row <- 1 to 10)
      yield makeRow(row)

    // add newling to end of each string
    tableSeq.mkString("\n")
}

println(multiTable())


