#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
/* 15.3 pattern guard conditionally match using if in addition to type match
 *
 */

// factory methods autogenerated
// no need for new Var("x")
var v = Var("x")

// factory methods are really nice when nested
val op = BinOp("+", Number(1), v)

// convert addition of x to itself to multiply by 2
def simplifyAdd(e: Expr) = e match {
  // case BinOp("+", x, x) not allowed to repeat x - "x is already defined"
  case BinOp("+", x, y) if x == y =>
    BinOp("*", x, Number(2))
  case _ => e
}

// match positive integers
def positiveInt(i: Int) = i match {
  case n: Int if 0 < n => println("positive number " + n)
  case _ => println("not postivite number")
}

positiveInt(3)
positiveInt(-3)

def beginsWithA(s: String) = s match {
  case s: String if s(0) == 'a' => println("Begins with a")
  case _ => println("Does not begin with a")
}

beginsWithA("about")
beginsWithA("tube")
