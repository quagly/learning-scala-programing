/*
 * see 15.6
 * sealed super class prevents
 * subclasses from being defined outside this file
 *
 * this allows the compiler to know whether every case is being pattern matched
 */

sealed abstract class Expr

case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
  left: Expr, right: Expr) extends Expr
