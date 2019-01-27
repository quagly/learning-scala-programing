#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala -feature "$0" "$@"
!#
/*
 * Demonstrate how operators are methods
 * and using the three types
 * infix
 * prefix
 * postfix
 */

/*
 * import postfixOps when using postfix operators
 * to avoid warnings
 * style guide says not to use them
 * https://docs.scala-lang.org/style/method-invocation.html#arity1
 */
import scala.language.postfixOps

// most common is the INFIX operator

// infix plus for ints
val sum = 1 + 2
// is the same as
val sumMore = 1.+(2)

// infix arbitrary method call on string
// works for any object and method
val s = "Hello World!"
s indexOf 'o'
// same as
s.indexOf('o')

// if a method takes multiple parameters put them in parens
s.indexOf('o', 5)

/*
 * PREFIX
 * There are 4 unary prefix operators
 * You can define these for your own objects
 * but cannot create new ones
 * they are
 * +  usually add/append
 * -  usually subract/remove
 * !  usually not
 * ~  usually flip bits
 */
val neg = -2.0
// same as
val negMethod = (2.0).unary_-

/*
 * POSTFIX
 * Scala convention is to leave off parens on method calls if it takes no parameters
 * and has no side-effects
 * postfix operators can have strange consequences
 * throws warning by default in 2.10
 * style guide says to avoid
 */
s.toLowerCase
// can be written as
// but not recommended
s toLowerCase
