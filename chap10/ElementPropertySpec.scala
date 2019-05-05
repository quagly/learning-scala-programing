import org.scalatest.WordSpec
import org.scalatest.prop.PropertyChecks
import org.scalatest.MustMatchers._
import Element.elem

// generates data to test against

// compiles but fails when run
// java.lang.NoSuchMethodException: ElementPropertySpec.main([Ljava.lang.String;)
class ElementPropertySpec extends WordSpec with PropertyChecks {
  "elem result" must {
    "have passed width" in {
      forAll { (w: Int) =>
        whenever (w > 0) {
          elem('x', w, 3).width must equal (w)
        }
      }
    }
  }
}


