#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

// see page 346 for why not to import mutable.Set
import scala.collection.mutable
import scala.collection.immutable.{TreeSet, TreeMap}

/* Sets and Maps
 *
 * Set
 * only one of each object as defined by ==
 * will be contained in a set
 * see page 348 for table of common set operations
 *
 * Maps
 * see pages 350-351 for table of common map operations
 *
 */

// Set
// count distinct words
val text = "See Spot run.  Run, Spot. Run!"

val wordsArray = text.split("[ !,.]+")

val words = mutable.Set.empty[String]

for (word <- wordsArray)
  words += word.toLowerCase

println(words)

// Map

// mutable Map
val map = mutable.Map.empty[String, Int]

map("hello") = 1
map("there") = 2
println(map)

println(map("hello"))

// count the number of times a word appears in a string
def countWords(text: String) = {
  val counts = mutable.Map.empty[String, Int]
  for (rawWord <- text.split("[ ,!.]+")) {
    val word = rawWord.toLowerCase
    val oldCount =
      if (counts.contains(word)) counts(word)
      else 0
    counts += (word -> (oldCount + 1))
  }
  counts
}

println(countWords(text))

// default sets and maps
//
// mutable
// by default sets and maps are backed by hashes for fast lookups
// HashSet and HashMap
// immutable
// Sets use special implementation for Sets smaller than 5
// 5 or more get HashSet
// Same with Maps

// sorted sets and maps
// immutable only
val ts = TreeSet(9, 3, 1, 8, 9, 0, 2, 7, 4, 6, 5)
// it is sorted
println(ts)

var tm = TreeMap(3 -> 'x', 1 ->'x', 4 -> 'x')
tm += (2 -> 'x')
// sorted
println(tm)
