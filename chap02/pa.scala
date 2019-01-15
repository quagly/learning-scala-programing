#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#

// print args, one per line
// args.foreach(arg => println(arg))

// same with parameter type
// args.foreach((arg: String) => println(arg))

// more concise
// if a function literal consists of one statement that takes a single argument
// you need not name and specify the argument
// called "partially applied function"
// args.foreach(println)

// imperitive expression for
for (arg <- args)
  println(arg)


