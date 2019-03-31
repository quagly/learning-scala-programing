class LineElement(s: String)
  // invoke superclass constructor
  extends ArrayElement(Array(s)) {
    override def width = s.length
    override def height = 1
}
