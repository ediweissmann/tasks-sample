package util

trait EitherWrap {
  def asEither[T](pass: => T): Either[Throwable, T] = {
    try {
      Right(pass)
    } catch {
      case e => Left(e)
    }
  }
}
