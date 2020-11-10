package app.com.org.service.Interpreter

import app.com.org.domain._
import org.specs2.mutable.Specification

class InputParserInterpreterTest extends Specification {
  "InputParserInterpreter" should {
    "return Intersection for lines" in {
      val lines = List("N true false", "S false true", "W false true", "E false false")
      val expected = Right(Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false))))

      val actual = new InputParserInterpreter {}.parse(lines)

      actual mustEqual expected
    }

    "return `InvalidNorthLaneInput` for lines if input for N direction is not given" in {
      val lines = List("S false true", "W false true", "E false false")
      val expected = Left(InvalidNorthLaneInput)

      val actual = new InputParserInterpreter {}.parse(lines)

      actual mustEqual expected
    }

    "return `InvalidSouthLaneInput` for lines if input for N direction is not given" in {
      val lines = List("N true false","W false true", "E false false")
      val expected = Left(InvalidSouthLaneInput)

      val actual = new InputParserInterpreter {}.parse(lines)

      actual mustEqual expected
    }

    "return `InvalidWestLaneInput` for lines if input for N direction is not given" in {
      val lines = List("N true false", "S false true", "E false false")
      val expected = Left(InvalidWestLaneInput)

      val actual = new InputParserInterpreter {}.parse(lines)

      actual mustEqual expected
    }

    "return `InvalidEastLaneInput` for lines if input for N direction is not given" in {
      val lines = List("N true false", "S false true", "W false false")
      val expected = Left(InvalidEastLaneInput)

      val actual = new InputParserInterpreter {}.parse(lines)

      actual mustEqual expected
    }
  }
}
