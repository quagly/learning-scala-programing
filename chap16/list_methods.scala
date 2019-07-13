#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

// 16.6 first order List methods
val fruit = List("apples", "oranges", "pears")
val nums = List(1, 2, 3)
val diag3 =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty = List()

// concatenation
println(List(1, 2) ::: List(3, 4, 5))
println(List() ::: List(1, 2, 3))
println(List(1, 2, 3) ::: List(4))

/* implementation of contatentation by hand
 * is a good example of how to do List processing
 * using divide and conquer principle
 *
 * concatenated list must have the same type
 * but can be any type
 * so signature is like as below
 * type parameters explained in chap 19
 */
def append[T](xs: List[T], ys: List[T]): List[T] =
  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }

println(append(List(1, 2), List(3, 4, 5)))

// length
// length traverses the list to count
println(List(1, 2, 3).length)

// accessing the end of the list
// end of list counterparts to head and tail
// are last and init
// unlike head and tail these traverse the whole list
// so take time
// so organize List so that accessed elements are at the front
val abcde = List('a', 'b', 'c', 'd', 'e')
println(abcde.last)
println(abcde.init)

// reverse
// if you require access to the end of a list
// frequently then reverse it
println(abcde.reverse)
// reverse creates a new list since lists are immutable

// reasoning about lists
assert(abcde.reverse.init == abcde.tail.reverse)
assert(abcde.reverse.tail == abcde.init.reverse)
assert(abcde.reverse.head == abcde.last)
assert(abcde.reverse.last == abcde.head)

// hand implement list reverse
// this is quadtratic time
// because it recurces on the end of the list
// see page 330 for a more efficient implementation
def rev[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case x :: xs1 => rev(xs1) ::: List(x)
}

println(rev(abcde))

/* Prefixes and Suffixes
 * drop, take, splitAt
 *
 * drop and take are generalizations of tail and init
 * take returns first n elements
 * drop returns elements except the first n
 * splitAt splits the list at an index returning two lists
 */

val n = 2
println(abcde take n)
println(abcde drop n)
println(abcde splitAt n)

// these return the same result but splitAt only traverses the list once
assert( abcde.splitAt(n) == (abcde take n, abcde drop n))

/* Element Selection: apply and indices
 * random element selection
 */

// long form, not idiomatic
println(abcde apply 2)
// short form, idiomatic
println(abcde(2))

// apply requires traversing the list, it is implemented as drop and head
assert(abcde(2) == (abcde drop 2).head)

// indices start at 0
println(abcde.indices)

/*
 * Flattening
 * takes a list of lists and creates as single list
 * all elements of the list must be lists
 */
val listOfList = List(
  List(1, 2),
  List(3),
  List(),
  List(4, 5)
)
println(listOfList.flatten)
assert(listOfList.flatten == List(1, 2, 3, 4, 5))

println(fruit.map(_.toCharArray).flatten)

/*
 * Zip and Unzip
 *
 * zip takes two lists and forms a list of pairs
 *
 * unzip converts list of tuples to tuples of lists
 *
 * 16.9 provides a more concise way to operate on lists together
 */

// hmm, this appears to be a Vector of pairs
println(abcde.indices zip abcde)
// because indices returns a Range, not a List
println(abcde.indices.getClass)
// so make it a list
println(abcde.indices.toList zip abcde)

// when lists are of different lengths unmatched elements are dropped

val zipped = abcde zip (List(1 ,2 ,3))
println(zipped)

// zipWithIndex gives indexes for free
println(abcde.zipWithIndex)

// unzip
println(zipped.unzip)

/*
 * Displaying lists: toString and mkString
 * toString is just the normal string representation
 * mkString(pre, sep, post) is for customization
 * addString to append to a StringBuilder
 *
 * mkString and addString work with any collection
 */
println(abcde mkString ("[", ",", "]"))
println(abcde mkString (""))
println(abcde mkString ("List(", ", ", ")"))

val buf = new StringBuilder
abcde addString (buf, "(", ";", ")")
println(buf)

/*
 * converting lists
 * iterator, toArray, copyToArray
 *
 * toArray list -> array
 * toList array -> list
 */

var arr = abcde.toArray
arr.toList

// copy to array copies list elements to an array at position
abcde copyToArray (arr, 3)

var arr2 = new Array[Int](10)
List(1, 2, 3) copyToArray (arr2, 3)
println(arr2.mkString(", "))

// iterator
val it = abcde.iterator
println(it.next)
println(it.next)

