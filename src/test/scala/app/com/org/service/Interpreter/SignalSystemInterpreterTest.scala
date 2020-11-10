package app.com.org.service.Interpreter

import app.com.org.domain._
import org.specs2.mutable.Specification

class SignalSystemInterpreterTest extends Specification {
  "SignalSystem" should {
    "send always `Red` signal when outgoing dirction is U-Turn" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(true), RightLane(true)),
        WestRoad(LeftLane(false), RightLane(false)), EastRoad(LeftLane(false), RightLane(false)))
      val vehicleRequest = VehicleRequest(West, West)
      val expected = Red

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

    "send always `Green` signal when outgoing dirction is Left-Turn" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(true), RightLane(true)),
        WestRoad(LeftLane(true), RightLane(true)), EastRoad(LeftLane(true), RightLane(true)))
      val vehicleRequest = VehicleRequest(North, East)
      val expected = Green

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

    "send `Green` signal when outgoing dirction is opposite direction and vehicle is not present on left lanes of left and right roads" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(true), RightLane(true)),
        WestRoad(LeftLane(false), RightLane(true)), EastRoad(LeftLane(false), RightLane(true)))
      val vehicleRequest = VehicleRequest(North, South)
      val expected = Green

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

    "send `Red` signal when outgoing dirction is opposite direction and vehicle is present on left lanes of left road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(true), RightLane(true)),
        WestRoad(LeftLane(true), RightLane(true)), EastRoad(LeftLane(false), RightLane(true)))
      val vehicleRequest = VehicleRequest(North, South)
      val expected = Red

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

    "send `Red` signal when outgoing dirction is opposite direction and vehicle is present on left lanes of right road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(true), RightLane(true)),
        WestRoad(LeftLane(false), RightLane(true)), EastRoad(LeftLane(true), RightLane(true)))
      val vehicleRequest = VehicleRequest(North, South)
      val expected = Red

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

    "send `Green` signal when outgoing dirction is right direction and vehicle is not present on left lanes of remaining roads" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(false), RightLane(true)),
        WestRoad(LeftLane(false), RightLane(true)), EastRoad(LeftLane(false), RightLane(true)))
      val vehicleRequest = VehicleRequest(North, West)
      val expected = Green

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

    "send `Red` signal when outgoing dirction is right direction and vehicle is present on left lane of left roads" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(true), RightLane(true)),
        WestRoad(LeftLane(false), RightLane(true)), EastRoad(LeftLane(false), RightLane(true)))
      val vehicleRequest = VehicleRequest(North, West)
      val expected = Red

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

    "send `Red` signal when outgoing dirction is right direction and vehicle is present on left lane of opposite roads" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(false), RightLane(true)),
        WestRoad(LeftLane(true), RightLane(true)), EastRoad(LeftLane(false), RightLane(true)))
      val vehicleRequest = VehicleRequest(North, West)
      val expected = Red

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

    "send `Red` signal when outgoing dirction is right direction and vehicle is present on left lane of right roads" in {
      val intersection = Intersection(NorthRoad(LeftLane(true), RightLane(true)), SouthRoad(LeftLane(false), RightLane(true)),
        WestRoad(LeftLane(false), RightLane(true)), EastRoad(LeftLane(true), RightLane(true)))
      val vehicleRequest = VehicleRequest(North, West)
      val expected = Red

      val actual = new SignalSystemInterpreter {}.signalFor(intersection, vehicleRequest)

      actual mustEqual expected
    }

  }
}
