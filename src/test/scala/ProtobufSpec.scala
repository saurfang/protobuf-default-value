import com.twitter.data.proto.tutorial.AddressBookProtos.Person
import org.scalatest._

class ProtobufSpec extends FlatSpec with Matchers {

  val bobPerson = Person.newBuilder.setId(0).setName("bob").build
  val bobPersonBytes = bobPerson.toByteString
  val parsedBob = Person.parseFrom(bobPersonBytes)

  val bobWithEmptyEmail = bobPerson.toBuilder.setEmail("").build
  val bobWithEmptyEmailBytes = bobWithEmptyEmail.toByteString
  val parsedBobWithEmptyEmail = Person.parseFrom(bobWithEmptyEmailBytes)

  val emailDescriptor = Person.getDescriptor.findFieldByNumber(Person.EMAIL_FIELD_NUMBER)

  "Protobuf serializer" should "serialize field even with default value" in {
    bobPersonBytes should not be bobWithEmptyEmailBytes
  }

  it should "returns the same value using getField"  in {
    parsedBob.getField(emailDescriptor) should be (parsedBobWithEmptyEmail.getField(emailDescriptor))
  }

  it should "be able to distinguish whether ID is set" in {
    parsedBob.hasField(emailDescriptor) should be (false)
    parsedBobWithEmptyEmail.hasField(emailDescriptor) should be (true)
  }


}
