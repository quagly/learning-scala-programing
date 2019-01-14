#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#
import scala.collection.mutable

// Maps can be mutable or immutable

// immutable by default

// mutable
// empty map, no values passed in ()
// since no values passed, explicit types are required, [Int, String] since
// type inference dependes on values
val treasureMap = mutable.Map[Int, String]()
// this is very cool
// 1 -> "Go to island" means call the -> method on 1 which returns a tuple2
// this works with any object (!)
// then the tuple2 in map context becomes a map
// this uses a Scala feature called "implicit conversion"
treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")
println(treasureMap(2))

// default immutable map
val romanNumeral = Map(
  1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
)
println(romanNumeral(4))


