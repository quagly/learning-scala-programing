#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

/*
 * 16.7 higher order methods on class list
 */

val diag3 =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )

/*
 * map, flatmap, and foreach
 */

// map
// apply to each element of the list
println(List(1, 2, 3) map (_ + 1))

val words = List("the", "quick", "brown", "fox")

println(words map (_.length))

println(words map (_.toList.reverse.mkString))

// flatmap
// takes a function returning a list of each element
// then flattens the result into a single list

println(words map (_.toList))
println(words flatMap (_.toList))

// this is example is not easy.  More in Chapter 23
// find all pairs (i, j) where 1 <= j < i < 5
var listOfPairs = List.range(1, 5) flatMap (
  i => List.range(1, i) map (j => (i, j))
)
println(listOfPairs)

// break it down
// instead of using i just hardcode 1
println(
  List.range(1, 5) map (j => (1, j))
)

// flatMap on a list maps the list to collection and then flattens out the collection

// gives List of pairs List((1, 1), (1, 2), (1, 3), (1, 4))

// the above listOfPairs is equivenant to nested loops
listOfPairs = for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)
println(listOfPairs)

// foreach
// takes a 'procedure' ( a function with return type Unit )
// it returns Unit

// add all elements of the list
var sum = 0
List(1, 2, 3, 4, 5) foreach (sum += _)
println(sum)

/*
 * Filtering
 *
 * filter
 * partition
 * find
 * takeWhile
 * dropWhile
 * span
 */

//filter by boolean expression

//even numbers
println(List(1, 2, 3, 4, 5) filter (_ % 2 == 0))

// words of length 3
println(words filter (_.length == 3))

// partition
// returns a pair of lists
// one for false and one for true

println(List(1, 2, 3, 4, 5) partition (_ % 2 == 0))

// find
// returns the first matching element
// return value is option
// Some(x) for a match
// None for no match
println(List(1, 2, 3, 4, 5) find (_ % 2 == 0))
println(List(1, 2, 3, 4, 5) find (_ < 0))

// option take apart using pattern match from chap 15
println(List(1, 2, 3, 4, 5) find (_ % 2 == 0)  match {
  case Some(s) => s
  case None => 0
})

// takeWhile dropWhile
// seems to take the first part of the list as long as the condition is true
// stops on first false

println(List(1, 2, 3, -4, 5) takeWhile (_ > 0))
println(words dropWhile (_ startsWith "t"))

// span
// returns two lists
// as if combining takeWhile and dropWhile to split the list
println(List(1, 2, 3, -4, 5) span (_ > 0))

// forall and exists
// boolean operations
// forall, true for all test
// exists, true for at least one test

// is there a row with all zeros in the matrix?
def hasZeroRow(m: List[List[Int]]) =
  m exists ( row => row forall (_ == 0))

println(hasZeroRow(diag3))

/*
 * fold
 * fold left and fold right operators
 * /: and :\
 *
 * combine the elements of the list with some operator
 *
 * fold is idiomatic scala
 * seems to be preferred by scala experts where possible
 * functional
 * often opaque to me, need to get a feel for it
 */

/* fold left involves three objects
 * (z /: xs)(op)
 * start value z
 * list xs
 * binary operation op
 *
 * op is applied between successive elements of the list, prefixed by z
 * for example
 * (z /: List(a, b, c))(op) equals op(op(op(z, a), b), c)
 */

// concatenate all words in a list of strings with spaces between them and in front
println( ("" /: words) (_ + " " + _) )

// if you don't want an extra space at the begining use this fold left idiom to
// use the first element of the list as the start value
println( (words.head /: words.tail) (_ + " " + _) )

// can also use foldLeft method rather than /: operator for readability
println( words.tail.foldLeft(words.head)(_ + " " + _) )

// foldLeft
// from https://twitter.github.io/scala_school/collections.html#fold
val numbers = List(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
println(numbers.foldLeft(0)((m: Int, n: Int) => m + n))
// foldLeft with print for debugging
numbers.foldLeft(0) { (m: Int, n: Int) => println("m: " + m + " n: " + n); m + n }

// skipped foldRight examples since I have never seen foldRight used and it is probably slower
// see top of page 330 for why

// list reversal using fold
// a linear time implementation of reversing a list
// compare with previous implementation - rev - which was quadratic time
// see page 330 for full explaination
// note that [T] is required due to limiations of type inference described
// in section 16.10

// start value is empty list of type [T]
def reverseLeft[T](xs: List[T]) =
  (List[T]() /: xs) {(ys, y) => y :: ys}

println(reverseLeft(List(1, 2, 3 ,4 ,5)))

// can I create a debug version?
def reverseLeftDebug[T](xs: List[T]) =
  (List[T]() /: xs) {
    (ys, y) => {
      println(s"accumulator is ${ys} value is ${y}")
      y :: ys
    }
  }

println(reverseLeftDebug(List(1, 2, 3 ,4 ,5)))

//sortWith
//sort list with comparison operator
println(numbers sortWith (_ < _))
println(words sortWith (_.length < _.length))

