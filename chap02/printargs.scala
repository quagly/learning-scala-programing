#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#
var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}
