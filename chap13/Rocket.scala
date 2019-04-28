// demonstrate access of compainion objects

// a class shares object rights with its compainion
// and vice-versa
// for example an object can access all private members of its companion class
// and a class can access all private members of its companion object
class Rocket {
  import Rocket.fuel
  // Rocket class can access companion object member fuel
  private def canGoHomeAgain = fuel > 20
}

object Rocket {
  private def fuel = 10
  def chooseStrategy(rocket: Rocket) = {
    // Rocket object can access private compainion class method canGoHomeAgain()
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickAStar()
  }
  def goHome() = {}
  def pickAStar() = {}
}
