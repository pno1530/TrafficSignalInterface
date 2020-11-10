package app.com.org.service
import app.com.org.domain.Error

trait TrafficSignallingSystem[Signal, Intersection, VehicleRequest] {
  def intersection: String =>  Either[Error, Intersection]

  def processRequest: Intersection => VehicleRequest => Signal

  def execute(filePath: String, vehicleRequest: VehicleRequest) = for{
    intersection <- intersection(filePath)
  } yield processRequest(intersection)(vehicleRequest)
}
