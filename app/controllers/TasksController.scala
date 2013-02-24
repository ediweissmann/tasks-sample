package controllers

import com.codahale.jerkson.Json._
import play.api.mvc._
import dao.{Repositories}

object TasksController extends Controller with Repositories {

  def list() = Action {
    Ok(generate(tasks.list()))
  }
}
