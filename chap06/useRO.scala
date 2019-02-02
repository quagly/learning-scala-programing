#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -feature "$0" "$@"
!#
// trying out RationalOperator
// this would be as tests if I knew how to do that in scala yet

// see chap 21 for a nicer way to work with implicits
import scala.language.implicitConversions
// implicit conversion converts int to RationalOperator as needed
// to support int method cast that don't exist like
// 1 * new(RationalOperator(1,2)
implicit def intToRationalOperator(x: Int) =  new RationalOperator(x)

val h = new RationalOperator(1,2)
val p = new RationalOperator(3,2)

println("fractions are h=" + h + " p=" + p)

println("two rationals")
println("h+p=" + (h + p))
println("h-p=" + (h - p))
println("h*p=" + (h * p))
println("h/p=" + (h / p))

println("rational then integer - overloading operators")
println("h+2=" + (h + 2))
println("h-2=" + (h - 2))
println("h*2=" + (h * 2))
println("h/2=" + (h / 2))

println("integer then rational - implicit conversion to custom object")
println("2+h=" + (2 + h))
println("2-h=" + (2 - h))
println("2*h=" + (2 * h))
println("2/h=" + (2 / h))
