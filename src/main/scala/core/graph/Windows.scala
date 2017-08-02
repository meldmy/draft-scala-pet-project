package warsztat.graph

import java.awt.Rectangle


/**
  * @author Dmytro Melnychuk
  */
trait Windows {
  def getX(): Double

  def getY(): Double

  def getWidth(): Double

  def getHeight(): Double

  def setFrame(x: Double, y: Double, w: Double, h: Double)

  def translate(x: Double, y: Double) {
    setFrame(x, y, getWidth(), getHeight())
  }

  override def toString: String = f"${getX()}, ${getY()}, ${getWidth()}, ${getHeight()}"
}

object MixingMethodApp extends App {

  val v = new Rectangle(5, 7, 90, 45)
  println(v)
  println(v.translate(1, 2))
  println(v)

  import java.awt.geom.Ellipse2D

  var ellipse = new Ellipse2D.Double(4, 5, 10, 12) with Windows
  println(ellipse)
  ellipse.translate(10, 15)
  println(ellipse)

  trait Logged {
    def log(msg: String) {}
  }

  trait ConsoleLogger extends Logged {
    override def log(msg: String) {
      println(msg)
    }
  }

  trait TimestampLogger extends Logged {
    override def log(msg: String) {
      super.log(new java.util.Date() + " " + msg)
    }
  }

  trait ShortLogger extends Logged {
    val maxLength = 15

    override def log(msg: String) {
      super.log(
        if (msg.length <= maxLength) msg
        else msg.substring(0, maxLength - 3) + "...")
    }
  }

  class SavingsAccount extends Logged {
    private var balance: Double = 0

    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }

  val acct1 = new SavingsAccount with ConsoleLogger
    with TimestampLogger with ShortLogger
  acct1.withdraw(1000)

  val acct2 = new SavingsAccount
    with ConsoleLogger with ShortLogger with TimestampLogger {
    override val maxLength = 35
  }
  acct2.withdraw(1000)

  val acct3 = new SavingsAccount
    with ShortLogger with TimestampLogger with ConsoleLogger
  acct3.withdraw(1000)
}
