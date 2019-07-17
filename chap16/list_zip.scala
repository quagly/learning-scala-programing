#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

// 16.9 Processing lists together
// using zipped

// processes two lists by pairs
// drop extra values if list lengths do not match
println((List(10, 20), List(3, 4 ,5)).zipped.map(_ * _))

// forall
// does the second list contain the lengths of strings in the first list?
println((List("abc", "de"), List(3, 2)).zipped.
  forall(_.length == _))

// exists
// is there any element of the second list that is not the length of
// corrosponding element of the first list?
println((List("abc", "de"), List(3, 2)).zipped.
  exists(_.length != _))
