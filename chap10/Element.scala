import Element.elem

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
  def width: Int =
    if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for (
           (line1, line2) <- this1.contents zip that1.contents
         ) yield line1 + line2
    )
  }

  // match widths of Elements
  def widen(w: Int): Element =
    if (w <= width) this
    else {
      // left and right padding to widen
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width , height)
      left beside this beside right
    // ensuring is from chapter 14 page 262
    // asserts that the argument w is less than or equal to the
    // width of of the element returned
    // if false then throws assertion error
    } ensuring (w <= _.width)

  // match heights of Elements
  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString = contents mkString "\n"
}

/* compantion singleton for factory methods
 * a nice interface for client so they don't need to
 * know about the object hierarcy and different object types
 *
 * in addition to factory method elem
 * we can make classes private within the singleton
 * companion class
 */
object Element {

  private class ArrayElement(
    val contents: Array[String]
  ) extends Element

  private class LineElements(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }

  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  ) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element =
    new LineElement(line)
}
