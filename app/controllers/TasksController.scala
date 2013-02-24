package controllers

import com.codahale.jerkson.Json._
import play.api.mvc._
import dao.{Repositories}
import controllers.actions.CreateTaskAction
import util.{CannedResponses, EitherWrap}

object TasksController extends Controller with Repositories with EitherWrap with CannedResponses {

  def list() = Action {
    Ok(generate(tasks.list()))
  }

  def create() = CreateTaskAction { case taskTitle =>
    asEither {
      tasks.add(taskTitle)
    }.fold(
      exception => errorResponse(exception),
      response => okResponse()
    )
  }
}
