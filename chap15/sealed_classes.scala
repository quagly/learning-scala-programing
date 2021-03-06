#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
/* 15.5 sealed classes allow the compiler to know if every type is checked
 * useful for avoiding default case
 */

// factory methods autogenerated
// no need for new Var("x")
var v = Var("x")

// factory methods are really nice when nested
val op = BinOp("+", Number(1), v)

/*
 * example of compiler error
 *
 * warning: match may not be exhaustive.
 * It would fail on the following inputs: BinOp(_, _, _), UnOp(_, _)
 *
 *def describe(e: Expr): String = e match {
   * case Number(_) => "a number"
   * case Var(_) => "a variable"
 * }
 */

// if you want to avoid the warning you can use the @unchecked annotation
// annotations are covered in chap 27
def describe(e: Expr): String = (e: @unchecked) match {
  case Number(_) => "a number"
  case Var(_) => "a variable"
}
