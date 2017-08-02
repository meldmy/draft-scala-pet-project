package warsztat

/**
  * @author Dmytro Melnychuk
  */
trait Matcher {
  //suggests to use here def instead of val because we can change def to val in subclasess
  val index = 0.1394
  def matching: Double
}

trait Multiply {
  def multiply(first: Double, second: Double): Double = first * second
}

class QuickCalc extends Qu with Multiply{
  def matching: Double = index * 23
}

abstract class Qu extends Matcher {

}

object MatcherApp extends App{
  val calc = new QuickCalc()
  val result = calc.multiply(1.3, 3.0)
  println(result)
}

//trait - mnozenie, dzielenie. Klasa kalkulaor