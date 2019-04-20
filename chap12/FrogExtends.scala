class Animal

// extend superclass Animal
// and mix-in trait Philospophical
class FrogExtends extends Animal with Philosophical {
  override def toString = "green"
  // override Philosophical method
  override def philosophize() = {
    println("It ain't easy being " + toString + "!")
  }
}
