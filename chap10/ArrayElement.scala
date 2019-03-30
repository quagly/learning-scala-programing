class ArrayElement(conts: Array[String]) extends Element {
  /* two problems with this design are that
   * 1. it returns a mutable array that clients could change.
   *  best practice is to return a defensive copy
   * 2. no check that all elements of the array have the same length
   *  best practice is to check with a precondition in the contructor
   *  and throw an exception
   */
  def contents: Array[String] = conts
}
