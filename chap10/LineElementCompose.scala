class LineElementCompose(s: String) extends Element {
  // instead of subclassing ArrayElement
  // LineElementCompose instantiates Element and
  // composed of an Array of string
  val contents = Array(s)
  override def width = s.length
  override def height = 1
}
