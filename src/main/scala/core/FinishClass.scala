package core

/**
  * @author Dmytro Melnychuk
  */
//immutable class. Case classes is a POJO as a data class. It's Serializable class.
case class Room(name: String, price: Double, isAvailable: Boolean = false) {

  //Pattern matching
  def validate(room: Room): Boolean =
    room match {
      case Room(_, room, true) if room > 300 => true
      case _ => false
    }
}

class NiceAsset(val name: String, price: Double)


object FinishApp extends App {
  val credit = Room("credit", 500)
  val credit2 = Room("credit", 500)
  println(credit2.price)
  println(credit2.name)
  val deposite = new NiceAsset("dep", 34)
  println(deposite.name)

  println(credit.equals(deposite))
  println(credit.equals(credit2))
  println(credit == credit2)
  println(credit == credit2.copy())
  println("Is validate: " + credit.validate(new Room(" ", 0, true)))
  println("a" == "a")

  val zaz = credit.copy(name = "zaz")
  println(zaz)


  //tuples https://en.wikipedia.org/wiki/Tuple

  val coordinates = ("Dima", 2)
  val digga = "123" -> "124"
  println(coordinates._1)


  //Match object class instanceOf
  def valid(room: Room): Option[Room] = room match {
    case p: Room => Some(room)
    case _ => None
  }

  val room = valid(credit)
  val person = Some(coordinates)

  println(isss)

  def isss = {
    for {
      r <- room
      p <- person
    } yield {
      (r, p, "ok")
    }
  }

 println( person.flatMap(p =>
    room.map(r => "ok")))
}
