package app.com.org.service.Interpreter

import app.com.org.domain.InvalidFile
import org.specs2.mutable.Specification

class InputReaderInterpreterTest extends Specification {
  "InputReaderInterpreter" should {
    "return lines" in {
      val filePath = "src/test/resources/Input.txt"
      val expected = Right(List("N true false", "S false true", "W false true", "E false false"))

      val actual = InputReaderInterpreter.read(filePath)

      actual mustEqual expected
    }

    "return InvalidFile for invalid filepath" in {
      val filePath = "src/test/resources/In.txt"
      val expected = Left(InvalidFile)

      val actual = InputReaderInterpreter.read(filePath)

      actual mustEqual expected
    }

    "return empty list for empty file" in {
      val filePath = "src/test/resources/Empty.txt"
      val expected = Right(List())

      val actual = InputReaderInterpreter.read(filePath)

      actual mustEqual expected
    }
  }
}
