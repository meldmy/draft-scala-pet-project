package core.oop

import java.util.Calendar

/**
  * @author Dmytro Melnychuk
  */
class Time(hour: Int, minute: Int = 0) {
  private var minutesSinceMidnight = hour * 60 + minute

  def hours = minutesSinceMidnight / 60

  def minutes = minutesSinceMidnight % 60

  if (hour > 23 || hour < 0 || minute < 0 || minute > 59) throw new IllegalArgumentException

  override def toString: String = f"$hours : ${minute}%02d"

  def minutes_=(value: Int) {
    if (value < 0 || value > 60)
      throw new IllegalArgumentException
    minutesSinceMidnight = hours * 60 + value
  }

  def before(other: Time): Boolean = if (other.minutesSinceMidnight <= minutesSinceMidnight) true
  else false

  def -(other: Time): Int = Math.abs(minutesSinceMidnight - other.hours * 60 + other.minutes)

  def <(other: Time): Boolean = this - other < 0
}

object Time {
  def apply(hour: Int, minute: Int = 0): Time = new Time(hour, minute)
}

object TimeApp extends App {
  val now = Calendar.getInstance()
  val currentSecond: Int = now.get(Calendar.SECOND)
  val currentMinute: Int = now.get(Calendar.MINUTE)
  val currentHour: Int = now.get(Calendar.HOUR)

  println(s"$currentHour : $currentMinute : $currentSecond")

  val currentTime = new Time(currentHour, currentMinute)
  currentTime.minutes_=(43)
  println(s"currentTime = ${currentTime}")
  val hourBeforeTime = new Time(currentHour - 1, currentMinute)
  val minuteBeforeTime = new Time(currentHour - 1, currentMinute)

  println(currentTime.before(hourBeforeTime))
  println(currentTime.before(minuteBeforeTime))
  println(currentTime < minuteBeforeTime)
  println(currentTime - minuteBeforeTime)
  println(f"Current time = $currentTime")

  val incorrectHours = new Time(0)
  println(incorrectHours)
  currentTime.minutes = 50
  println(currentTime)

  val timee = Time(1, 2)
  println(Time(2, 2) - Time(1, 2))
  println(s"timee = ${timee}")
}
