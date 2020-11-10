package app.com.org.domain

import org.specs2.mutable.Specification

class IntersectionTest extends Specification {
  "Intersection" should {
    "return all lanes" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))

      val actual = intersection.allRoads

      actual mustEqual expected
    }

    "return remaining roads For North Road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))

      val actual = intersection.remainingRoadsFor(North)

      actual mustEqual expected
    }

    "return remaining roads For South Road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(
        NorthRoad(LeftLane(true),RightLane(false)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))

      val actual = intersection.remainingRoadsFor(South)

      actual mustEqual expected
    }

    "return remaining roads For West Road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(
        NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))

      val actual = intersection.remainingRoadsFor(West)

      actual mustEqual expected
    }

    "return remaining roads For East Road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(
        NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)))

      val actual = intersection.remainingRoadsFor(East)

      actual mustEqual expected
    }

    "return leftRight roads For North Road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(WestRoad(LeftLane(false),RightLane(true)), EastRoad(LeftLane(false),RightLane(false)))

      val actual = intersection.leftRightRoadsFor(North)

      actual mustEqual expected
    }

    "return leftRight roads For South Road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(WestRoad(LeftLane(false),RightLane(true)), EastRoad(LeftLane(false),RightLane(false)))

      val actual = intersection.leftRightRoadsFor(South)

      actual mustEqual expected
    }

    "return leftRight roads For West Road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)))

      val actual = intersection.leftRightRoadsFor(West)

      actual mustEqual expected
    }

    "return leftRight roads For East Road" in {
      val intersection = Intersection(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)),
        WestRoad(LeftLane(false),RightLane(true)),
        EastRoad(LeftLane(false),RightLane(false)))
      val expected = List(NorthRoad(LeftLane(true),RightLane(false)),
        SouthRoad(LeftLane(false),RightLane(true)))

      val actual = intersection.leftRightRoadsFor(East)

      actual mustEqual expected
    }
  }
}
