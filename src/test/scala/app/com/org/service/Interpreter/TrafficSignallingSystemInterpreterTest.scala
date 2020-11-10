package app.com.org.service.Interpreter

import app.com.org.domain._
import org.specs2.mutable.Specification

class TrafficSignallingSystemInterpreterTest extends Specification {
  "TrafficSignallingSystem" should {
    "return `Intersection` for file" in {
      val fileName = "src/test/resources/Input.txt"
      val expected = Right(Intersection(NorthRoad(LeftLane(true),RightLane(false)),SouthRoad(LeftLane(false),RightLane(true)),WestRoad(LeftLane(false),RightLane(true)),EastRoad(LeftLane(false),RightLane(false))))

      val actual = new TrafficSignallingSystemInterpreter {}.intersection(fileName)

      actual mustEqual expected
    }

    "return `InvalidFile` if filepath is not valid" in {
      val fileName = "src/test/resources/In.txt"
      val expected = Left(InvalidFile)

      val actual = new TrafficSignallingSystemInterpreter {}.intersection(fileName)

      actual mustEqual expected
    }

    "return `InvalidEastLaneInput` if content is not valid" in {
      val fileName = "src/test/resources/FaultyInput.txt"
      val expected = Left(InvalidEastLaneInput)

      val actual = new TrafficSignallingSystemInterpreter {}.intersection(fileName)

      actual mustEqual expected
    }

    "return `Signal` after processing request" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),SouthRoad(LeftLane(false),RightLane(true)),WestRoad(LeftLane(false),RightLane(true)),EastRoad(LeftLane(false),RightLane(false)))
      val vehicleRequest = VehicleRequest(North, North)
      val expected = Red

      val actual = new TrafficSignallingSystemInterpreter {}.processRequest(intersection)(vehicleRequest)

      actual mustEqual expected
    }
  }
}
