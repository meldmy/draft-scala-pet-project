package world
//instead of using import world.human._
import warsztat.human._

//instead of * asterisk in Scala we use underscore _
//change name inside the class

/**
  * @author Dmytro Melnychuk
  */
class WorldPopulation {
  def <--() {
    val someHuman = new Human()
    someHuman.printRead()
  }
}

object WorldRunner extends App {
  val --> = new WorldPopulation()
  --> <--

}
