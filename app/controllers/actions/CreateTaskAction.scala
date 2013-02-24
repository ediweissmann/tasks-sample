package controllers.actions

import play.api.mvc.{Action, SimpleResult, Results}
import play.api.data.Form
import play.api.data.Forms._

object CreateTaskAction extends Results {
  val form = Form(single(
    "title" -> text)
  )

  def apply(pass: String => SimpleResult[String]) = Action {
    implicit request =>
      form.bindFromRequest().fold(
        hasErrors => BadRequest,
        values => pass(values)
      )
  }
}
