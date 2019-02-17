#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -deprecation -feature "$0" "$@"
!#
println("FileMatcher.filesEnding(\"scala\").toList [" +
            FileMatcher.filesEnding("scala").toList + "]")

println("FileMatcher.filesContaining(\"Files1\").toList [" +
            FileMatcher.filesContaining("Files1").toList + "]")

println("FileMatcher.filesRegex(\".*Re.ex.*\").toList [" +
        FileMatcher.filesRegex(".*Re.ex.*").toList + "]")

