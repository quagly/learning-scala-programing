#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#

import scala.collection.immutable.TreeSet
import scala.collection.mutable

// 17.4
// Initializing collections

// most common way is to pass the initial elements
// to a factory method on the companion object
//
// place elements in parantheses after the companion object name
// and the scala compiler invokes apply method on the companion object

println(List(1, 2, 3))

println(mutable.Map("hi" -> 2, "there" -> 5))

// specify type
// scala will infertype, but may get it wrong
// type ANY must always be specified
val stuff = mutable.Set[Any](42)
stuff += "abracadabra"
println(stuff)

// initialize a collection with another collection
// you have a list but want a TreeSet
val colors = List("blue", "yellow", "red", "green")
// the factory method of TreeSet does not know how to take a list
// val treeSet = TreeSet(colors) errors
// first create an empty TreeSet[String]
// then add elements with the ++ operator
val treeSet = TreeSet[String]() ++ colors
println(treeSet)

// converting array or list
// this is strightforward
// but may be slow for large collections
// just invoke toList()
println(treeSet.toList)
// or toArray
println(treeSet.toArray)

// converting between mutable and immutable
// Sets and Maps

val mutaSet = mutable.Set.empty ++= treeSet
println(mutaSet)
val immutaSet = Set.empty ++ mutaSet
println(immutaSet)

// maps
val muta = mutable.Map("i" -> 1, "ii" -> 2)
println(muta)
val immu = Map.empty ++ muta
println(immu)

