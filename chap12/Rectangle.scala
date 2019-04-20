trait Rectangular {
  // abstract methods
  def topLeft: Point
  def bottomRight: Point

  // concrete methods based on abstract methods
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // many more geomtetric methods
}

// Component gets all the nice geometric methods from
// trait rectangular
abstract class Component extends Rectangular {
  // other methods
}


class Point(val x: Int, val y: Int)

class Rectangle(val topLeft: Point, val bottomRight: Point)
  extends Rectangular {
    // other methods
}
