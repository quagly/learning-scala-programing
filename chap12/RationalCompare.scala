// class parameters
// creates a primary contructor with these parameters for you
// don't know scaladoc standards yet
// note chap 30 shows how to override equals and hashcode so that
// intances can be used in hash tables or compared with ==
// mix-in Ordered take a "type parameter"
// type parameters are covered in chap 19
// note Ordered trait cannot define equals, see chap 30
class RationalCompare(n: Int, d: Int) extends Ordered[RationalCompare]{
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

  // define compare method to support Ordered trait
  // compare this with that
  // compare must return
  // 0 Integer if objects the same
  // negative if this is less than that
  // positive if this is greater than that
  def compare(that: RationalCompare) =
    (this.numer * that.denom) - (that.numer * this.denom)

  // auxiliary constructor
  // for creating 'integer' rationals
  // by passing in just one number
  def this(n: Int) = this(n, 1)

  // note that numer is the same as this.numer
  // plus operator method for rationals
  def + (that: RationalCompare): RationalCompare =
    new RationalCompare(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  // plus operator method for integer param
  def + (i: Int): RationalCompare =
    new RationalCompare(numer + i * denom, denom)

  //minus
  def - (that: RationalCompare): RationalCompare =
    new RationalCompare(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  // minus operator method for integer param
  def - (i: Int): RationalCompare =
    new RationalCompare(numer - i * denom, denom)

  // multiplication
  def * (that: RationalCompare): RationalCompare =
    new RationalCompare(numer * that.numer, denom * that.denom)

  // mltpy operator method for integer param
  def * (i: Int): RationalCompare =
    new RationalCompare(numer * i, denom)


  // divide
  def / (that: RationalCompare): RationalCompare =
    new RationalCompare(
      numer * that.denom, denom * that.numer
    )

  // divide operator method for integer param
  def / (i: Int): RationalCompare =
    new RationalCompare(numer, denom * i)

  // is that less than this?
  // don't need this now that we have Ordered trait
  // def lessThan(that: RationalCompare): Boolean =
    //numer * that.denom < that.numer * denom

  def max(that: RationalCompare): RationalCompare =
  // here we cannot get aways with an implicit this
  // because the object itself is getting returned, not a field value
  // use Ordered trait this.<
    if (<(that)) that else this

  // recusive functional greatest common denominator
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  // override toString for nice printing and debugging
  override def toString = n + "/" + d

}
