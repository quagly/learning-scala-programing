import scala.collection.mutable
/*
 * Just the final code for object
 * This is recommended style with a balance between
 * concise but with return types and
 * things that can be single line are
 * no return statement
 */
class ChecksumAccumulatorWithCompanion {
  // fields are public by default
  private var sum = 0
  def add(b: Byte): Unit = { sum += b }
  def checksum(): Int = ~(sum & 0xFF) + 1
}

/*
 * demonstrates "companion object" singleton
 * which is how scala supports static variable
 * companion objects can access private methods of the class
 * and are denoted with 'object' rather than 'class'
 * Singletons are defined in the same file as the class
 *
 * Singletons can also be used without a companion class
 * for utility methods
 * same pattern as a static object in java
 * this is called a "standalone object"
 */
object ChecksumAccumulatorWithCompanion {
  /* checksum cache consider
   * scala.collection.mutable.WeakHashMap
   * to allow values to be garbage collected
   * under memory pression
   */
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulatorWithCompanion
      // loop through each charachter of the string
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      // add string and checksum to map
      cache += (s -> cs)
      cs
    }
}
