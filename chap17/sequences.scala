#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

import scala.collection.mutable.{ListBuffer, ArrayBuffer}

/* 17.1 Sequences
 *
 * ordered elements
 * List - Immutable Linked List
 *  quick addition/retreival from the start of the list
 *  slow for positions toward the end of the list
 *
 * Array
 *  Efficiently access at an arbitrary position
 *  to get or update
 *
 * List buffer - Mutable
 *  for building lists with append
 *  more efficiant to create when added elements to the end
 *  consider just creating a normal list adding to the beginning
 *  and then reversing it instead
 *  can avoid stack overflow when creating lists using recursion
 *  see 22.2
 *
 *  ArrayBuffer - Mutable
 *    no need to specify size
 *    prints without needed mkString()
 *
 * Strings( via StringOps )
 *  any string can be treated as a sequence
 *
 */

// List - see chap16

// Array
val fiveInts = new Array[Int](5)
println(fiveInts.mkString(" "))

val fiveToOne = Array(5, 4, 3, 2, 1)
println(fiveToOne.mkString(" "))
fiveInts(0) = fiveToOne(4)
println(fiveInts.mkString(" "))

// List Buffer
val buf = new ListBuffer[Int]

buf += 1
buf += 2
println(buf)

3 +=: buf
buf.toList
println(buf)

// ArrayBuffer
val aBuf = new ArrayBuffer[Int]()

aBuf += 12
aBuf += 15

println(aBuf)
println(aBuf.length)
println(aBuf(0))

// String
def hasUpperCase(s: String) = s.exists(_.isUpper)

println(hasUpperCase("Robert Frost"))
println(hasUpperCase("e e cummings"))


