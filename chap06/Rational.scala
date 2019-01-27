// class parameters
// creates a primary contructor with these parameters for you
class Rational(n: Int, d: Int) {
  // precondition
  // used for validating parameters
  // require takes a boolean parameter that must be true
  // any code that is not in a method is
  // placed in the primary constructor
  require(d != 0)

  // immutable fields from class parameters
  val numer: Int = n
  val denom: Int = d

  // override toString for nice printing and debugging
  override def toString = n + "/" + d

  // note that numer is the same as this.numer
  def add(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  // is that less than this?
  def lessThan(that: Rational): Boolean =
    numer * that.denom < that.numer * denom

  def max(that: Rational): Rational =
  // here we cannot get aways with an implicit this
  // because the object itself is getting returned, not a field value
    if (lessThan(that)) that else this


}







