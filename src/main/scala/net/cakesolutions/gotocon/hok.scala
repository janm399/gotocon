package net.cakesolutions.gotocon

trait Packaging {
  type Package[A]

  def pack[A](a: A): Package[A]
}

class SuperPackageWithRibbon[A](a: A) {
  override def toString = "***xxx " + a + " xxx***"
}

trait ExpensivePackaging extends Packaging {
  type Package[A] = SuperPackageWithRibbon[A]

  def pack[A](a: A) = new SuperPackageWithRibbon(a)
}

trait CheapPackaging extends Packaging {
  type Package[A] = A

  def pack[A](a: A) = a
}

class Celebration(presents: Seq[_]) {
  this: Packaging =>

  def gimme = presents.map(pack _)
}

object Main extends App {

  val christmas = new Celebration("iPhone" :: "MacPro" :: Nil) with ExpensivePackaging
  val nameDay = new Celebration("Socks" :: "Teapot" :: Nil) with CheapPackaging

  println(christmas.gimme)
  println(nameDay.gimme)

}