package controllers

import com.codahale.jerkson.Json._
import play.api.mvc._
import dao.SquerylTaskRepository

object TasksController extends Controller {
  val tasks = new SquerylTaskRepository

  def list() = Action {
    Ok(generate(tasks.list()))
  }
}
