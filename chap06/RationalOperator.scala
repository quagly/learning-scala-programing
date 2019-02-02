// class parameters
// creates a primary contructor with these parameters for you
// don't know scaladoc standards yet
// note chap 30 shows how to override equals and hashcode so that
// intances can be used in hash tables or compared with ==
class RationalOperator(n: Int, d: Int) {
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
  // plus operator method for rationals
  def + (that: RationalOperator): RationalOperator =
    new RationalOperator(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  // plus operator method for integer param
  def + (i: Int): RationalOperator =
    new RationalOperator(numer + i * denom, denom)

  //minus
  def - (that: RationalOperator): RationalOperator =
    new RationalOperator(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  // minus operator method for integer param
  def - (i: Int): RationalOperator =
    new RationalOperator(numer - i * denom, denom)

  // multiplication
  def * (that: RationalOperator): RationalOperator =
    new RationalOperator(numer * that.numer, denom * that.denom)

  // mltpy operator method for integer param
  def * (i: Int): RationalOperator =
    new RationalOperator(numer * i, denom)


  // divide
  def / (that: RationalOperator): RationalOperator =
    new RationalOperator(
      numer * that.denom, denom * that.numer
    )

  // divide operator method for integer param
  def / (i: Int): RationalOperator =
    new RationalOperator(numer, denom * i)

  // is that less than this?
  def lessThan(that: RationalOperator): Boolean =
    numer * that.denom < that.numer * denom

  def max(that: RationalOperator): RationalOperator =
  // here we cannot get aways with an implicit this
  // because the object itself is getting returned, not a field value
    if (lessThan(that)) that else this

  // recusive functional greatest common denominator
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  // override toString for nice printing and debugging
  override def toString = n + "/" + d

}
