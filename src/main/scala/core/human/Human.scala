package warsztat.human

/**
  * @author Dmytro Melnychuk
  */
class Human() {
  def read() = "I can read it:  "
  def printRead() = println(read())

  def this(age: Int,text: String ) {
    this()
    println(text+". My age is: "+age)

  }
}

//Objects creates for functions that doesn't need some state of object. Has named as clean functions
object ZaharCreatorWithAge{
  def apply(age: Int) = new Human(age, "Zahar")
}

class HumanTwo(age: Int = 0, isLive: Boolean) {
  def this(age: Int){
    this(age, false)
  }

  def apply(name: String, nameSecond: String) = println(name+" "+nameSecond)

  def apply(name: String, age: Int) = println(name+" "+age)

  override def toString: String = "Age: "+age+". Human is alive: "+isLive
}



object HumanApp extends App {
  val me = new Human(2, "I'm here")
  //val someAge: Int = ???    create mock for this variable
  println(me.read())
  println(new HumanTwo(3))
  println(new HumanTwo(isLive = true))
  val b = new HumanTwo(2, true)
  //we use apply very often for builders and
  // Scala have a concept with
  b("To", "Ol")
  b("To", 3)


  ZaharCreatorWithAge(3)
}