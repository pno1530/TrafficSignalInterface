package app.com.org.domain

sealed trait Direction

case object North extends Direction
case object South extends Direction
case object West extends Direction
case object East extends Direction

object Direction{
  def leftDirection(direction: Direction ) = Map[Direction, Direction](
    North -> East,
    South -> West,
    West -> North,
    East -> South
  )(direction )

  def oppositeDirection(direction: Direction ) = Map[Direction, Direction](
    North -> South,
    South -> North,
    West -> East,
    East -> West
  )(direction )

  def rightDirection(direction: Direction ) = Map[Direction, Direction](
    North -> West,
    South -> East,
    West -> South,
    East -> North
  )(direction )
}