#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
// match is like a case statement
// the general form of a pattern is covered in chapter 15
// match returns a value
val firstArg = if (args.length > 0) args(0) else ""

val friend =
  firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }
println(friend)
