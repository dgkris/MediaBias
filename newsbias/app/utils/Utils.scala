package utils

import org.joda.time.DateTime
import org.joda.time.DateTimeZone

object Utils {

  /**
   * @param dateTime
   * @return datetime converted to system's local timezone
   */
  def convertToSystemTimezone(dateTime: DateTime): DateTime = {
    dateTime withZone (DateTimeZone forID (DateTimeZone getDefault () getID ()))
  }
  
}

