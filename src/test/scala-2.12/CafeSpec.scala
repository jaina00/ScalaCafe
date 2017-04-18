import org.scalatest.{Matchers, WordSpecLike}

import scala.collection.mutable

/**
  * Created by abhishek on 18/04/17.
  */
class CafeSpec extends WordSpecLike
  with Matchers {

  "Cafe" should {
    "produce total bill of 3.5 when Cola, Coffee and CheeseSandwich is added - no service charge applied" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich()), applyServiceCharge = false) shouldBe 3.5
    }

    "produce total bill of 8.0 when Cola, Coffee, CheeseSandwich and SteakSandwich is added - no service charge applied" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich(), SteakSandwich()), applyServiceCharge = false) shouldBe 8.0
    }

    "return 0.0 when no item is added - no service charge applied" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List.empty, applyServiceCharge = false) shouldBe 0.0
    }

    "return 0.0 when no item is added - service charge applied" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List.empty, applyServiceCharge = true) shouldBe 0.0
    }

    "return total without any service charge if all drinks - service charge applied" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), Coffee(), Cola()), applyServiceCharge = true) shouldBe 3.0
    }

    "return total with 10% service charge if there is a food item - service charge applied" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich(), Cola()), applyServiceCharge = true) shouldBe 4.4
    }

    "return total with 20% service charge if there is a hot food item - service charge applied" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), CheeseSandwich(), SteakSandwich()), applyServiceCharge = true) shouldBe 9.6
    }

    "return total with 20% service charge if there are hot food items and not cold food - service charge applied" in {
      val coffeeStore = new Cafe()
      coffeeStore.getTotal(List(Cola(), Coffee(), SteakSandwich(), SteakSandwich()), applyServiceCharge = true) shouldBe 12.60
    }

    "return total with max GBP 20.0 service charge - service charge applied" in {
      val coffeeStore = new Cafe()
      val items = mutable.ArrayBuffer[FoodItem]()
      for (i <- 0 until 50)
        items.append(SteakSandwich())
      items.append(Coffee())
      items.append(CheeseSandwich())
      items.append(Cola())

      coffeeStore.getTotal(items.toList, applyServiceCharge = true) shouldBe 248.5
    }
  }
}