/**
  * Created by abhishek on 18/04/17.
  */
sealed trait FoodItem {
  val price: BigDecimal
  val isDrink: Boolean
  val isHotFood: Boolean
}

case class Cola(
                 override val price: BigDecimal = 0.5,
                 override val isDrink: Boolean = true,
                 override val isHotFood: Boolean = false
               ) extends FoodItem

case class Coffee(
                   override val price: BigDecimal = 1.0,
                   override val isDrink: Boolean = true,
                   override val isHotFood: Boolean = true
                 ) extends FoodItem

case class CheeseSandwich(
                           override val price: BigDecimal = 2.0,
                           override val isDrink: Boolean = false,
                           override val isHotFood: Boolean = false
                         ) extends FoodItem

case class SteakSandwich(
                          override val price: BigDecimal = 4.5,
                          override val isDrink: Boolean = false,
                          override val isHotFood: Boolean = true
                        ) extends FoodItem
