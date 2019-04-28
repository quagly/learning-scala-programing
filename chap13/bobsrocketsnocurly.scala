// demonstrate alternative syntax
// works same as with curly braces
// avoids shifting things left
package bobsrocketsnocurly
package navigation
class Navigator {
  // A class can be accessed within it's own package
  // with out a prefix
  // No need to say bobsrockets.navigation.StarMap
  val map = new StarMap
}
class StarMap
class Ship {
// a package can be accessed from its containing package
// without needing a prefix
// No need to say bobsrockets.navigation.Navigator
val nav = new navigation.Navigator
}

// without ending curly brackets
// scala can't know that this is up a level
// seems that without curly brace syntax you can only nest down
// but not back up again
/*
package fleets
class Fleet {
  // when using curly brace syntax
  // all names accessible in scope outside the package
  // are available inside it
  // No need to say bobsrockets.Ship
  def addShip() = { new Ship }
}
}
*/
