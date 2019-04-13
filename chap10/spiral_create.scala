#!/bin/sh
docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala Spiral 6
