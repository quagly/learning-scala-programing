// class parameters
// creates a primary contructor with these parameters for you
// don't know scaladoc standards yet
class RationalMethod(n: Int, d: Int) {
  // precondition
  // used for validating parameters
  // require takes a boolean parameter that must be true
  // any code that is not in a method is
  // placed in the primary constructor
  require(d != 0)

  // get greatest common divisor of class parameters
  private val g = gcd(n.abs, d.abs)
  // immutable fields from class parameters
  val numer: Int = n / g
  val denom: Int = d / g

  // auxiliary constructor
  // for creating 'integer' rationals
  // by passing in just one number
  def this(n: Int) = this(n, 1)

  // note that numer is the same as this.numer
  def add(that: RationalMethod): RationalMethod =
    new RationalMethod(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  // is that less than this?
  def lessThan(that: RationalMethod): Boolean =
    numer * that.denom < that.numer * denom

  def max(that: RationalMethod): RationalMethod =
  // here we cannot get aways with an implicit this
  // because the object itself is getting returned, not a field value
    if (lessThan(that)) that else this

  // recusive functional greatest common denominator
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  // override toString for nice printing and debugging
  override def toString = n + "/" + d

}
