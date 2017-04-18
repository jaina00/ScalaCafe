/**
  * Created by abhishek on 18/04/17.
  */
class Cafe {
  def getTotal(items: List[FoodItem], applyServiceCharge: Boolean): BigDecimal = {
    val total = items.map(_.price).sum

    applyServiceCharge match {
      case true =>
        val serviceChargeRate = getServiceChargeRate(items)
        val serviceCharge: BigDecimal = if ((serviceChargeRate * total) > 20) 20.0 else serviceChargeRate * total
        total + serviceCharge
      case false => total
    }
  }

  private def getServiceChargeRate(items: List[FoodItem]) = {
    val anyFoodItems = items.exists(!_.isDrink) // Check if there is any food item
    val anyHotFoodItem = items.exists(x => {
      !x.isDrink && x.isHotFood
    }) // Check if there is any hot food item

    (anyHotFoodItem, anyFoodItems) match {
      case (true, _) => 0.2
      case (_, true) => 0.1
      case _ => 0.0
    }
  }
}
