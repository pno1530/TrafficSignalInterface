package app.com.org.domain

case class Intersection(
                         northRoad: NorthRoad,
                         southRoad: SouthRoad,
                         westRoad: WestRoad,
                         eastRoad: EastRoad) {
  def allRoads = List(northRoad, southRoad, westRoad, eastRoad)

  def remainingRoadsFor(prefix: Direction): Seq[Road] =
    allRoads.filterNot(_.toString.toLowerCase.contains(prefix.toString.toLowerCase()))

  def leftRightRoadsFor(prefix: Direction): Seq[Road] =
    remainingRoadsFor(prefix).filterNot(l =>
      l.toString.toLowerCase.contains(Direction.oppositeDirection(prefix).toString.toLowerCase))
}
sealed abstract class Road(val leftLane: LeftLane, val rightLane: RightLane)

case class NorthRoad(left: LeftLane, right: RightLane) extends Road(left, right)
case class SouthRoad(left: LeftLane, right: RightLane) extends Road(left, right)
case class WestRoad(left: LeftLane, right: RightLane) extends Road(left, right)
case class EastRoad(left: LeftLane, right: RightLane) extends Road(left, right)

sealed abstract class Lane(hasVehicle: Boolean = false)

case class LeftLane(hasVehicle: Boolean) extends Lane(hasVehicle)
case class RightLane(hasVehicle: Boolean) extends Lane(hasVehicle)