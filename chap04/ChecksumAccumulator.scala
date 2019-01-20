#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#
/*
 * Just the final code for object
 * This is recommended style with a balance between
 * concise but with return types and
 * things that can be single line are
 * no return statement
 */
class ChecksumAccumulator {
  // fields are public by default
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

val acc = new ChecksumAccumulator
acc.add(5)
println(acc.checksum())
