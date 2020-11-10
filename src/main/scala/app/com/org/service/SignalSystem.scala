package app.com.org.service

trait SignalSystem[Intersection, VehicleRequest, Signal] {
  def isApplied(intersection: Intersection, vehicleRequest: VehicleRequest): Boolean

  def signal: Signal
}
