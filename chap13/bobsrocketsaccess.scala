// mix bracket and not bracket package scope
// everything is simply under bobrocketaccess so no brackets
// minimizeds left indent
package bobsrocketsaccess

package navigation {
  // access modifiers set the scope of protection
  // private within package bobsrocketaccess
  private[bobsrocketsaccess] class Navigator {
    // protected within package navigation
    protected[navigation] def useStarChart() = {}
    class LegOfJourney {
      // distance private to class Navigator
      private[Navigator] val distance = 100
    }
    // 'this' is shorthand for access from the same object
    // the most private
    // inner classes / subclasses cannot access
    // can only be accessed by the same instance of Navigator
    private[this] var speed = 200
  }
}

package launch {
  import navigation._
  object Vehicle {
    // can access Navigator because it is private to
    // package bobsrocketsaccess and package launch
    // is in that package

    // guide is private to package launch
    private[launch] val guide = new Navigator
  }
}
