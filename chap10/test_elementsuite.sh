#!/bin/bash
#
# how far will I go before installing sbt?

# compile
docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scalac \
  -cp .:scalatest-app_2.12-3.0.5.jar ElementSuite.scala

# run
docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala \
  -cp .:scalatest-app_2.12-3.0.5.jar org.scalatest.run ElementSuite

