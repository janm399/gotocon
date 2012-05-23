package net.cakesolutions.gotocon


case class Order(customer: String, items: Seq[Item])
case class Item(price: BigDecimal, quantity: BigDecimal)

object Syn extends App {

  val order =
    Order("Jan Machacek",
      Item(10, 4) :: Item(5.5, 1) :: Item(12.5, 2) :: Nil)

  val total = order.items map { i => i.price * i.quantity } sum

  println(total)
}