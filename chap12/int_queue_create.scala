#!/bin/sh
exec docker run --rm --tty --interactive --volume $PWD:/app bigtruedata/sbt scala -deprecation -feature "$0" "$@"
!#
val queue = new BasicIntQueue

queue.put(10)
queue.put(20)

println(queue.get())
println(queue.get())

// no need to define a new class like this
// class MyQueue extends BasicIntQueue with Doubling
// when there is no code traits can be mixed in a object creation time with new

val doublingQueue = new BasicIntQueue with Doubling

doublingQueue.put(10)
println("get doubled int " + doublingQueue.get())

// order of with mixins is significant
// executiong starts to the right and moves left
// here we first filter.  The incrementing super.put() call
// calls Filtering.put()
// so the order is filtering then incrementing
println("filter then increment")
val incFilterQueue = (new BasicIntQueue
  with Incrementing with Filtering)

incFilterQueue.put(-1)
incFilterQueue.put(0)
incFilterQueue.put(1)

println(incFilterQueue.get())
println(incFilterQueue.get())


// now we will Filter and then Increment
println("increment then filter")
val filterIncQueue = (new BasicIntQueue
  with Filtering with Incrementing)

filterIncQueue.put(-1)
filterIncQueue.put(0)
filterIncQueue.put(1)

println(filterIncQueue.get())
println(filterIncQueue.get())
println(filterIncQueue.get())




