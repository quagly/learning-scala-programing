/*
 * Value class example
 *
 * a value class much conform to these contraints
 *
 *  exactly one parameter
 *  nothing but defs
 *  no class can extend it
 *  cannot redefine equals or hashcode
 *  extends AnyVal
 */
class Dollars(val amount: Int) extends AnyVal {
  override def toString() = "$" + amount
}
