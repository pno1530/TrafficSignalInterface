package app.com.org.service
import app.com.org.domain.Error

trait InputReader[A] {
  def read(filePath: String): Either[Error, A]
}
