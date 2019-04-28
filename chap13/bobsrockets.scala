package bobsrockets {
  package navigation {
    class Navigator {
      // A class can be accessed within it's own package
      // with out a prefix
      // No need to say bobsrockets.navigation.StarMap
      val map = new StarMap
    }
    class StarMap
  }
  class Ship {
    // a package can be accessed from its containing package
    // without needing a prefix
    // No need to say bobsrockets.navigation.Navigator
    val nav = new navigation.Navigator
  }
  package fleets {
    class Fleet {
      // when using curly brace syntax
      // all names accessible in scope outside the package
      // are available inside it
      // No need to say bobsrockets.Ship
      def addShip() = { new Ship }
    }
  }
}
