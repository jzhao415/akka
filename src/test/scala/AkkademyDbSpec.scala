import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import com.akkademy.{AkkademyDb, SetRequest}
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

class AkkademyDbSpec extends FunSpecLike with Matchers with BeforeAndAfterEach{

  implicit val system = ActorSystem()
  describe("akkademyDb") {
    describe ("given SetRequest"){
      it("should place key/value into map"){
        val actorRef = TestActorRef(new AkkademyDb)
        actorRef ! SetRequest("he","is learing akka, and will succeed")
        actorRef ! SetRequest("she","is working hard as well")
        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("he") should equal(Some("is learing akka, and will succeed"))
        akkademyDb.map.get("she") should equal(Some("is working hard as well"))
      }
    }
  }
}
