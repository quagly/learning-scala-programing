#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
/* case class Expr examples from section 15.2
 *
 * shows different kinds of patterns
 * see sample code https://booksites.artima.com/programming_in_scala_3ed/examples/case-classes-and-pattern-matching/Misc.scala
 */

// factory methods autogenerated
// no need for new Var("x")
var v = Var("x")

// factory methods are really nice when nested
val op = BinOp("+", Number(1), v)

// natural equals implementation added
assert(op.right == Var("x"))

// copy method added
// to copy and object while changing attributes
// e.g., copy op but change the operator
val opMinus = op.copy(operator = "-")

/* **********************
 * begin section 15.2
 */

// expression to detect type
// expr is the abstract class, need to find out which concrete class it is

def checkBinary(expr: Expr) {
  expr match {
    // case BinOp(op, left, right) =>
    // use wildcards for BinOp parameters
    // since we don't care what the parameters are
    case BinOp(_, _, _) =>
      println(expr + "is a binary operation")
    case _ => println("It is non-binary") // handle default case
  }
}

// isBinary
checkBinary(op)
// is not Binary
checkBinary(v)

// constant pattern match
def describe(x: Any) = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi!"
  case Nil => "the empty list"
  case _ => "something else"
}

println(describe(5))
println(describe(true))
println(describe("hello"))
println(describe(List()))
println(describe(List(1,2,3)))

// variable pattern match
// see book example

// deep pattern
// match BinOp where third contructor parameters
// is a number and it's value is 0
def deepMatch(expr: Expr) = expr match {
  case BinOp("+", e, Number(0)) => println("a deep match")
  case _ =>
}

deepMatch(op)

val opAddZero = BinOp("+", v, Number(0))

deepMatch(opAddZero)

// Sequence pattern
def listStartsWithZero(x: Any) = x match {
  case List(0, _, _) => println("Three Element List starts with Zero")
  case List(0, _*) => println("Non Three Element List that starts with Zero")
  case _ =>
}

listStartsWithZero(List(0,1,2))
listStartsWithZero(List(0,1,2,3))

// Tuple pattern
// match any three element tuple
def tupleDemo(expr: Any) = expr match {
  case (a, b, c) => println("matched " + a + b + c)
  case _ =>
}

tupleDemo(("a ", 3, "-tuple"))

// typed pattern
def genericSize(x: Any) = x match {
  case s: String => s.length
  case m: Map[_, _] => m.size
  case _ =>  -1
}

println(genericSize("abc"))
println(genericSize(Map(1 -> 'a', 2 -> 'b')))
println(genericSize(math.Pi))

// variable binding
// see book
