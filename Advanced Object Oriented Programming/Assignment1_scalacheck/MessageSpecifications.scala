import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

class MessageSpecifications extends Properties("Message"){
  property("startsWith") = forAll { (a: Message, b: Message) =>
    (a.
  }
}