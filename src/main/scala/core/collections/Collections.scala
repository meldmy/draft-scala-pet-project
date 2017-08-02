package core.collections

/**
  * @author Dmytro Melnychuk
  */
object Collections extends App{
  private val one = 1
  private val two = 2
  private val three = 3
  val immutableL = getList(one, two,three)

  def getList(digits: Int*):List[Int] = {
    digits toList
  }

  println(immutableL.take(2))

  val v1 = immutableL.fold(1) {case(a,item) => a*item}
  val v2 = immutableL.fold(1) {(a,item) => a*item}

  println(v1)
  println(v2)

  val set = Set("a", "b", "c")
  val map = Map(one -> "a", two -> "b")
  val arr = Array(one, two, three)
}
