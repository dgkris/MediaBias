package controllers

import play.api._
import play.api.mvc._

object NewsController extends Controller {

  def create = Action { implicit request =>
    Ok("hello world")
  }

  def read = Action { implicit request =>
    Ok("hello world")
  }

  def update = Action { implicit request =>
    Ok("hello world")
  }

  def delete = Action { implicit request =>
    Ok("hello world")
  }

}