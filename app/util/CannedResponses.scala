package util

import com.codahale.jerkson.Json._
import play.api.mvc._

trait CannedResponses extends Results {

  def okResponse() = {
    Ok(generate(Success()))
  }

  def errorResponse(ex: Throwable) = {
    Ok(generate(Failure(ex.getMessage)))
  }
}

case class ApplicationResponse(success: Boolean, msg: String)

object Success {
  def apply() = new ApplicationResponse(true, "")
}

object Failure {
  def apply(msg: String) = new ApplicationResponse(false, msg)
}