#!/bin/bash
#
# fails to throw IAE
#
set -e

# compile
docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scalac \
  -cp .:scalatest-app_2.12-3.0.5.jar:scalacheck_2.12-1.14.0.jar \
  ElementPropertySpec.scala

# run
docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala \
  -cp .:scalatest-app_2.12-3.0.5.jar:scalacheck_2.12-1.14.0.jar \
  ElementPropertySpec

