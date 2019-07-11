#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

// 16.1 list literals
val fruit = List("apples", "oranges", "pears")
val nums = List(1, 2, 3)
val diag3 =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty = List()

/* 16.2
 * lists are immutable
 * list are recursive (linked list)
 * lists are homogeneous - elements have the same type
 * types may be explicit as in these examples
 */
val fruitType: List[String] = List("apples", "oranges", "pears")
val numsType: List[Int] = List(1, 2, 3)
val diag3Type: List[List[Int]] =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val emptyType: List[Nothing] = List()

/* 16.3 Contructors
 * List are made of two building blocks
 * Nil and :: ( pronouced "cons" )
 * :: is the infix operator and adds elements to the front of the list
 * like x :: xs adds x to the front of list xs
 * another alternative to contructs the lists above is below
 */
val fruitCons = "apples" ::  ("oranges" :: ("pears" :: Nil))
val numsCons = 1 :: ( 2 :: ( 3 :: ( 4 :: Nil )))
val diag3Cons = (1 :: (0 :: ( 0 :: Nil ))) ::
            (0 :: (1 :: ( 0 :: Nil ))) ::
            (0 :: (0 :: ( 1 :: Nil ))) :: Nil
val emptyCons = Nil

// because :: ends in a colon it associates to the right so the parenthesis are unneccessary
val fruitSansParen = "apples" ::  "oranges" :: "pears" :: Nil
val numsSansParen = 1 :: 2 :: 3 :: 4 :: Nil
val diag3SansParen = (1 :: 0 :: 0 :: Nil ) ::
            (0 :: 1 :: 0 :: Nil ) ::
            (0 :: 0 :: 1 :: Nil ) :: Nil
val emptySansParen = Nil

