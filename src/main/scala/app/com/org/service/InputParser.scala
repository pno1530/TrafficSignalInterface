package app.com.org.service

import app.com.org.domain.Error

trait InputParser[A] {
  def parse(lines: List[String]): Either[Error, A]
}