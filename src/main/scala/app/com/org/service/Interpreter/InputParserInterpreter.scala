package app.com.org.service.Interpreter

import app.com.org.domain._
import app.com.org.service.InputParser

import scala.util.Try

trait InputParserInterpreter extends InputParser[Intersection]{
  import InputParser._

  private def parseLane[A <: Road](lines: List[String])(implicit parser: InputParser[A]): Either[Error, A] =
    parser.parse(lines)

  def parse(lines: List[String]): Either[Error, Intersection] = for {
    n <- parseLane[NorthRoad](lines)
    s <- parseLane[SouthRoad](lines)
    w <- parseLane[WestRoad](lines)
    e <- parseLane[EastRoad](lines)
  } yield Intersection(n, s, w, e)

}

object InputParser{

  implicit def NorthLaneParser: InputParser[NorthRoad] = new InputParser[NorthRoad]{
    def matchesLane(line: String) = line.contains("N")

    override def parse(lines: List[String]): Either[Error, NorthRoad] = lines.filter(matchesLane(_)) match {
      case Nil => Left(InvalidNorthLaneInput)
      case l => {
        val words = l(0).split(" ").toList
        Try(NorthRoad(LeftLane(words(1).toBoolean), RightLane(words(2).toBoolean)))
          .fold(_ => Left(InvalidNorthLaneInput), lane => Right(lane))
      }
    }
  }

  implicit def SouthLaneParser: InputParser[SouthRoad] = new InputParser[SouthRoad]{
    def matchesLane(line: String) = line.contains("S")

    def parse(lines:  List[String]): Either[Error, SouthRoad] = lines.filter(matchesLane(_)) match {
      case Nil => Left(InvalidSouthLaneInput)
      case l => {
        val words = l(0).split(" ").toList
        Try(SouthRoad(LeftLane(words(1).toBoolean), RightLane(words(2).toBoolean)))
          .fold(_ => Left(InvalidSouthLaneInput), lane => Right(lane))
      }
    }
  }

  implicit def WestLaneParser: InputParser[WestRoad] = new InputParser[WestRoad]{
    def matchesLane(line: String) = line.contains("W")

    override def parse(lines: List[String]): Either[Error, WestRoad] = lines.filter(matchesLane(_)) match {
      case Nil => Left(InvalidWestLaneInput)
      case l => {
        val words = l(0).split(" ").toList
        Try(WestRoad(LeftLane(words(1).toBoolean), RightLane(words(2).toBoolean)))
          .fold(_ => Left(InvalidWestLaneInput), lane => Right(lane))
      }
    }
  }

  implicit def EastLaneParser: InputParser[EastRoad] = new InputParser[EastRoad]{
    def matchesLane(line: String) = line.contains("E")

    override def parse(lines: List[String]): Either[Error, EastRoad] = lines.filter(matchesLane(_)) match {
      case Nil => Left(InvalidEastLaneInput)
      case l => {
        val words = l(0).split(" ").toList
        Try(EastRoad(LeftLane(words(1).toBoolean), RightLane(words(2).toBoolean)))
          .fold(_ => Left(InvalidEastLaneInput), lane => Right(lane))
      }
    }
  }
}

