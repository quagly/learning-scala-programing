abstract class Element {
  def contents: Array[String]
  /* parameterless methods are used when there are no parameters and
   * the method accesses mutable state only by reading the field of the object
   * and does not change state, only read
   * parameterless have no () in their declaration, this is different than empty parens
   * they can be replaced by field definitions with no change to any client
   * methods take less memory and are slower than fields
   */
  // parameterless height method
  def height: Int = contents.length
  // equivilent height field
  // val height = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length


}
