#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

// 16.1 list literals
val fruit = List("apples", "oranges", "pears")
val nums = List(1, 2, 3)
val diag3 =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty = List()

/* 16.4 operations
 * all operations on lists can be expressed in terms of three operations
 *
 *  head - returns the first element
 *  tail - returns a list consisting of all elements except the first
 *  isEmpty - returns true of the list is empty
 *
 * these are methods of class List
 */
println(empty.isEmpty)
println(fruit.isEmpty)
println(fruit.head)
println(fruit.tail.head)
println(diag3.head)

/* insert sort recursive algorithim
 * for list of int
 * nice example of why tail returns everything but the first element
 * helpful for recursion
 */
def isort(xs: List[Int]) : List[Int] =
  if (xs.isEmpty) Nil
  else insert(xs.head, isort(xs.tail))

def insert(x: Int, xs: List[Int]): List[Int] =
  // is list exhuasted or x less than or equal to first element, then put x first
  if (xs.isEmpty || x <= xs.head) x :: xs
  // else work through the list to find an element that x is less than or equal to
  else xs.head :: insert(x, xs.tail)

val unsortedInts = 5 :: 2 :: 4 :: 3 :: Nil
println(unsortedInts)
println(isort(unsortedInts))

/* 16.5 List patterns
 * match all elements with List(...)
 * or some elements with :: Nil
 *
 * see chapter 26 to learn about extractor patterns
 */

// match a three element list
val List(a, b, c) = fruit
println(a + " " + b + " " + c)

// if you don't know the number of elements then use :: syntax
// match first two elements and get the rest of the list as list
val a1 :: b1 :: rest = fruit
println(a1 + " " + b1+ " " + rest)

// taking list apart with :: can be used instead of head, tail, isEmpty
// here is insertion sort written with pattern matching
def isortp(xs: List[Int]) : List[Int] = xs match {
  case List() => List()
  case x :: xs1 =>  insertp(x, isortp(xs1))
}

def insertp(x: Int, xs: List[Int]): List[Int] = xs match {
  // is list exhuasted or x less than or equal to first element, then put x first
  case List() => List(x)
  // else work through the list to find an element that x is less than or equal to
  case y :: ys => if ( x<= y) x :: xs
                  else y :: insertp(x, ys)
}

println(unsortedInts)
println(isortp(unsortedInts))



