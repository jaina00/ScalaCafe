/**
  * Created by abhishek on 18/04/17.
  */
class Cafe {
  def getTotal(items: List[FoodItem]): BigDecimal = {
    items.map(_.price).sum
  }
}
