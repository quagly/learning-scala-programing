class ArrayElementParametric(
  /* 10.5
   * parametric field example
   * defines a parameter and a field on one go
   * can also be var to be mutable
   * but I don't want to change parameter values
   * can be private or protected.
   */
  val contents: Array[String]
) extends Element
