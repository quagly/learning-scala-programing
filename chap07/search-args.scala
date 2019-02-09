#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// use recursion to search the argument list
// for an arg that ends with ".scala" and does not start with a "-"
def searchFrom(i: Int): Int =
  if (i >= args.length) - 1
  else if (args(i).startsWith("-")) searchFrom(i + 1)
  else if (args(i).endsWith(".scala")) i  // return i - we found it!
  else searchFrom(i + 1)

// start searching recursively from the zeroth arg
val i = searchFrom(0)
println(args(i))
