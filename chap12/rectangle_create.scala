#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
// rectagle example
val rect = new Rectangle(
  new Point(1, 1),
  new Point(10, 10)
)

println(rect.left)
println(rect.right)
println(rect.width)



