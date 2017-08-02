package core.collections

/**
  * @author Dmytro Melnychuk
  */
object ForgetAboutLoopsApp extends App {
  private val zones = java.util.TimeZone.getAvailableIDs
  private val partionedTimeZones: Array[String] = extractTimeZonesGroupedBy(10)

  private def extractTimeZonesGroupedBy(groupedBy: Int): Array[String] = {
    zones
      .map(s => s.split("/"))
      .filter(_.length > 1)
      .map(_ (1))
      .grouped(groupedBy)
      .toArray
      .map(_ (0))
  }

  println(partionedTimeZones.mkString(", "))
}

