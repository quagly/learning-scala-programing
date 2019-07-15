#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

// 16.6 merge sort

// take two parameters
// of the same type to compare with Boolean comarison
// and a list of items of that type to sort
def msort[T](less: (T, T) => Boolean)
  (xs: List[T]): List[T] = {

    // break into two lists and sort together
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }

println(msort((x:Int, y: Int) => x < y)(List(5, 7, 1, 3)))

// this is a good example of a function crated for currying
// create a integer sort function to sort a list of ints
val intSort = msort((x: Int, y: Int) => x < y) _

println(intSort(List(5, 7, 1, 3)))

val reverseIntSort = msort((x: Int, y: Int) => x > y) _
println(reverseIntSort(List(5, 7, 1, 3)))

