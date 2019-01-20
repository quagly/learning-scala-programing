import ChecksumAccumulatorWithCompanion.calculate
/*
 * Shows how to use App trait to simplify application entry point
 *
 */

/*
 * standalone entrypoint
 */
object FallWinterSpringSummer extends App {
    for ( arg <- args )
      println(arg + ": " + calculate(arg))
}
