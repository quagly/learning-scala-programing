#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -feature "$0" "$@"
!#
val filename =
  if (!args.isEmpty) args(0)
  else "default.txt"

println(filename)

