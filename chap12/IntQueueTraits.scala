// contains all IntQueue stackable traits

/*
 * stackable trait
 *
 * extends IntQueue means it can only be used on an IntQueue class
 *
 * abstract override is for traits only, not classes
 * it means that this trait can only be mixed in to classes
 * that implement this method
 *
 * it modified the method calling super
 * super is undefined at trait compile time
 * super is dynamically bound for traits, not for classes
 *
 * This modifies the existing method put and makes it double the int
 * in the queue
 */
trait Doubling extends IntQueue {
  abstract override def put(x: Int) = { super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if ( x>= 0 ) super.put(x)
  }
}


