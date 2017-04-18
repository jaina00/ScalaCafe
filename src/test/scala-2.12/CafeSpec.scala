import org.scalatest.{Matchers, WordSpecLike}

import scala.collection.mutable

/**
  * Created by abhishek on 18/04/17.
  */
class CafeSpec extends WordSpecLike
  with Matchers {

  "Cafe" should {
    "produce total bill of 3.5 when Cola, Coffee and CheeseSandwich is added " in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich()), false) shouldBe 3.5
    }

    "produce total bill of 8.0 when Cola, Coffee, CheeseSandwich and SteakSandwich is added" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich(), SteakSandwich()), false) shouldBe 8.0
    }

    "return 0.0 when no item is added" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List.empty, false) shouldBe 0.0
    }

    "return total without any service charge if all drinks" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), Coffee(), Cola()), true) shouldBe 3.0
    }

    "return total with 10% service charge if there is a food item" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich(), Cola()), true) shouldBe 4.4
    }

    "return total with 20% service charge if there is a hot food item" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich(), SteakSandwich()), true) shouldBe 9.6
    }

    "return total with max GBP 20.0 service charge" in {
      val coffeeStore = new Cafe()
      val items = mutable.ArrayBuffer[FoodItem]()
      for (i <- 0 until 50)
        items.append(SteakSandwich())
      items.append(Coffee())
      items.append(CheeseSandwich())
      items.append(Cola())

      coffeeStore.getTotal(items.toList, true) shouldBe 248.5
    }

  }

}