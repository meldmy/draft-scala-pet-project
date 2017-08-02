package warsztat

/**
  * @author Dmytro Melnychuk
  */
class Dog {

  def bark(voiceLevel: Int) {

    for (index <- 1 to voiceLevel) {
      println("Wuf "+index+" times. Ahaha")
    }
  }

  def returnFive(): Int = {
    5
  }

}

object Calculator {

  def pow(digit: Int, value: Int): Int = {
    var res =digit
    for(i <- 1 to value) res *= digit
    res
  }

}

object Owner extends App{

  def bakrMyDog() {
    val myDoge = new Dog
    myDoge bark 8
  }

  def pow(digit: Int, value: Int): Int = {
    val calc = Calculator
    calc.pow(digit, value)
  }

  bakrMyDog()
  println(pow(2,3))

  var x = 2
  def z = if(x%2==0) "even" else "odd"
  println(z)
  x = 5
  println(z)
  println(x)
}