package app.com.org.service.Interpreter

import app.com.org.domain.{Error, InvalidFile}
import app.com.org.service.InputReader

import scala.io.Source
import scala.util.Try

trait InputReaderInterpreter extends InputReader[List[String]]{

  override def read(filePath: String): Either[Error, List[String]] = {
    Try(Source.fromFile(filePath).getLines().toList).fold(_ => Left(InvalidFile), lines => Right(lines) )
  }

}
object InputReaderInterpreter extends InputReaderInterpreter