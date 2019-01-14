#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/scala scala "$0" "$@"
!#
import scala.collection.mutable
import scala.collection.immutable.HashSet

// Sets can be mutable or immutable

// immutable by default as here
var jetSet = Set("Boeing", "Airbus")
// append and create new immutable set
jetSet += "Lear"
println("immutable default Set")
println(jetSet.contains("Cessna"))

// mutable
val movieSet = mutable.Set("Hitch", "Potergeist")
// modify movieSet
movieSet += "Shreck"
println("mutable Set")
println(movieSet)

// immutable HashSet
val hashSet = HashSet("Tomatoes", "Chilies")
println("immutable hashSet")
println(hashSet + "Coriander")





