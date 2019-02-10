#!/bin/bash
# find lines longer than 45 char in LongLines.scala file
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature \
  FindLongLinesLocal 45 LongLinesLocal.scala
