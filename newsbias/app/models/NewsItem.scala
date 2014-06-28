package models

class EntityType extends Enumeration { val Organization, Person, Location = Value }

case class Entity(name:String, entityType:EntityType, sentimentScore:Float)

case class NewsItem(url:String, title:String, description:String, entities:List[Entity]) 

object NewsItem {
  
  def create (newsItem:NewsItem) : NewsItem  = {
    newsItem
  }
  
  def read (newsItem: NewsItem) : NewsItem = {
    newsItem
  }
  
  def update (newsItem: NewsItem) : NewsItem = {
    newsItem
  }
  
  def delete (newsItem: NewsItem) : Boolean = {
    false
  }
  
}