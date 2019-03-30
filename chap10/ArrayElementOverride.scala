class ArrayElementOverride(conts: Array[String]) extends Element {
  // the parameterless method in abstract Element
  // can be overridden with a field
  // fields, methods, packages, and singleton objects all live in the same namespace
  val contents: Array[String] = conts
}
