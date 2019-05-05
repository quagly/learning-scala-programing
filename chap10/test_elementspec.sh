#!/bin/bash
#
# fails to throw IAE
#

# compile
docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scalac \
  -cp .:scalatest-app_2.12-3.0.5.jar ElementSpec.scala

# run
docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala \
  -cp .:scalatest-app_2.12-3.0.5.jar org.scalatest.run ElementSpec

