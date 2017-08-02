package warsztat.converter

/**
  * @author Dmytro Melnychuk
  */
class ConverterUtil {
  def convertTime(hours: Int): Int = if (hours > 12) hours - 12 else hours

  //foldLeft give us order and fold can't
  def silnia(digit: Int): Int = (1 to digit).foldLeft(1) { (acc, i) => acc * i }

  val getText =
    """This is
      |a text
      |here! '*' """.stripMargin

}

object Ap extends App {
  val sca = new ConverterUtil
  val a = "variable A"
  println(s"This is: $a. ${sca.getText}")

  //scala closure function
  var x = 3

  def multipl(dig: Int) = x * dig

  println(multipl(3))
  x = 1
  println(multipl(3))


  def sumLetters(mainWord: String) = {
    def worlds(some: String) = some.length
      mainWord.split(" ").map(worlds).sum
  }

  //carrign
  def power(x: Int)(y: Int) = Math.pow(x, y)

  //take 2 to the x
  def pow2 = power(2)(_)

  val z = pow2(5)


  println(z)
  println(sumLetters("aa aa"))

  val value = 3
  println("Factorial for"+value+" is "+sca.silnia(value))
}