import org.scalatest.{Matchers, WordSpecLike}

/**
  * Created by abhishek on 18/04/17.
  */
class CafeSpec extends WordSpecLike
  with Matchers {

  "Cafe" should {
    "produce total bill of 3.5 when Cola, Coffee and CheeseSandwich is added " in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich())) shouldBe 3.5
    }

    "produce total bill of 8.0 when Cola, Coffee, CheeseSandwich and SteakSandwich is added" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich(), SteakSandwich())) shouldBe 8.0
    }

    "return 0.0 when no item is added" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List.empty) shouldBe 0.0
    }
  }

}