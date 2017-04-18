/**
  * Created by abhishek on 18/04/17.
  */
sealed trait FoodItem {
  val price: BigDecimal
}

case class Cola(
                 override val price: BigDecimal = 0.5
               ) extends FoodItem

case class Coffee(
                   override val price: BigDecimal = 1.0
                 ) extends FoodItem

case class CheeseSandwich(
                           override val price: BigDecimal = 2.0
                         ) extends FoodItem

case class SteakSandwich(
                          override val price: BigDecimal = 4.5
                        ) extends FoodItem
