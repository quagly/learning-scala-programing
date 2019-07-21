#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

// 17.5 Tuples

// tuples hold objects of different types
println(1, "hello", Console)

// tuples are not traversable

// tuples are a common way to return multiple vaulues
def longestWord(words: Array[String]) = {
  var word = words(0)
  var idx = 0
  for (i <- 1 until words.length)
    if ( words(i).length > word.length) {
      word = words(i)
      idx = i
    }
  (word, idx)
}

println(longestWord("The quick brown fox".split(" ")))

// easy assignment
val (word, idx) = longestWord("The quick brown fox".split(" "))
println(s"${word}, ${idx}")
//
