package viewmodels

import models.{ EntityType, Entity }
import org.joda.time.DateTime
import java.util.Date
import utils.Utils

case class EntityTimeSeries(nameDateTimeCombo: String, name: String, entityType: EntityType, sentimentScore: Float, mentionCount: Long)

case class EntityDaily(date: String, name: String, entityType: EntityType, totalSentiment: Float, totalMentions: Long)

case class EntityWeekly(weekStartDate: String, name: String, entityType: EntityType, totalSentiment: Float, totalMentions: Long)

case class EntityMonthly(monthStartDate: String, name: String, entityType: EntityType, totalSentiment: Float, totalMentions: Long)

case class EntityYearly(yearStartDate: String, name: String, entityType: EntityType, totalSentiment: Float, totalMentions: Long)

object EntityTimeSeries {

  def createOrUpdateTimeSeries(entity: Entity, newsDateTime: DateTime, mentionCount:Int = 1): Boolean = {

    val convertedNewsDateTime = Utils convertToSystemTimezone(newsDateTime)
    
    val yearStartDate = convertedNewsDateTime withYear(convertedNewsDateTime getYear()) withTime(0, 0, 0, 0)
    val monthStartDate = convertedNewsDateTime withMonthOfYear(convertedNewsDateTime getMonthOfYear()) withTime(0, 0, 0, 0)
    val weekStartDate = convertedNewsDateTime withWeekOfWeekyear(convertedNewsDateTime getWeekOfWeekyear()) withDayOfWeek(1) withTime(0, 0, 0, 0)
    
    
    var entityTimeSeries = new EntityTimeSeries(convertedNewsDateTime getMillis() toString(),entity.name, entity.entityType, 
        entity.sentimentScore, mentionCount)
    
    
    
    false
  }

}