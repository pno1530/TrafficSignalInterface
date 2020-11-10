package app.com.org.domain

import org.specs2.mutable.Specification

class DirectionTest extends Specification {
  "Direction" should {
    "return left of North" in {
      val expected = East

      val actual = Direction.leftDirection(North)

      actual mustEqual expected
    }

    "return right of North" in {
      val expected = West

      val actual = Direction.rightDirection(North)

      actual mustEqual expected
    }

    "return opposite of North" in {
      val expected = South

      val actual = Direction.oppositeDirection(North)

      actual mustEqual expected
    }

    "return left of South" in {
      val expected = West

      val actual = Direction.leftDirection(South)

      actual mustEqual expected
    }

    "return right of South" in {
      val expected = East

      val actual = Direction.rightDirection(South)

      actual mustEqual expected
    }

    "return opposite of South" in {
      val expected = North

      val actual = Direction.oppositeDirection(South)

      actual mustEqual expected
    }

    "return left of West" in {
      val expected = North

      val actual = Direction.leftDirection(West)

      actual mustEqual expected
    }

    "return right of West" in {
      val expected = South

      val actual = Direction.rightDirection(West)

      actual mustEqual expected
    }

    "return opposite of West" in {
      val expected = East

      val actual = Direction.oppositeDirection(West)

      actual mustEqual expected
    }

    "return left of East" in {
      val expected = South

      val actual = Direction.leftDirection(East)

      actual mustEqual expected
    }

    "return right of East" in {
      val expected = North

      val actual = Direction.rightDirection(East)

      actual mustEqual expected
    }

    "return opposite of East" in {
      val expected = West

      val actual = Direction.oppositeDirection(East)

      actual mustEqual expected
    }
  }
}
