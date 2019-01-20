import ChecksumAccumulatorWithCompanion.calculate
/*
 * Scala application
 *
 * entry point of a Scala application
 * is a standalone object with a main method
 * that takes an Array[String]
 * and has a result type of Unit
 */

// why result type unit?
// can I pass a value back to the shell from Scala?
// isn't returning something nice and functional?

/*
 * standalone entrypoint
 */
object Summer {
  def main(args: Array[String]) = {
    // what does scala offer for argument parsing and validation?
    for ( arg <- args )
      println(arg + ": " + calculate(arg))
  }
}
