package app.com.org.service.Interpreter

import app.com.org.domain._
import app.com.org.service.TrafficSignallingSystem

trait TrafficSignallingSystemInterpreter
  extends TrafficSignallingSystem[Signal, Intersection, VehicleRequest]
  with InputReaderInterpreter
  with InputParserInterpreter
    with SignalSystemInterpreter{

  override def intersection: String => Either[Error, Intersection] = (filePath: String) => for{
    lines <- read(filePath)
    intersection <- parse(lines)
  } yield intersection

  override def processRequest: Intersection => VehicleRequest => Signal =
    (intersection : Intersection) => (vehicleRequest: VehicleRequest) => {
      signal(intersection, vehicleRequest)
  }

  private def signal(intersection: Intersection, vehicleRequest: VehicleRequest): Signal = {
    signalFor(intersection, vehicleRequest)
  }

}