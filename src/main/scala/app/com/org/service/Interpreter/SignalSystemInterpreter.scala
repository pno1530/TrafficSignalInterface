package app.com.org.service.Interpreter

import app.com.org.domain._
import app.com.org.service.SignalSystem

trait SignalSystemInterpreter {

  def signalFor(intersection: Intersection, vehicleRequest: VehicleRequest): Signal =
    List(UTurnSignalSystem, LeftDirectionTurnSignalSystem, OppositeDirectionTurnSignalSystem, RightDirectionTurnSignalSystem)
      .find(_.isApplied(intersection: Intersection, vehicleRequest: VehicleRequest))
      .getOrElse(DefaultSignalSystem).signal


  private def UTurnSignalSystem: SignalSystem[Intersection, VehicleRequest, Signal] = new SignalSystem[Intersection, VehicleRequest, Signal]{

    def isApplied(intersection: Intersection, vehicleRequest: VehicleRequest) =
      vehicleRequest.incoming == vehicleRequest.outgoing

    override def signal: Signal = Red
  }

  private def LeftDirectionTurnSignalSystem: SignalSystem[Intersection, VehicleRequest, Signal] = new SignalSystem[Intersection, VehicleRequest, Signal]{

    def isApplied(intersection: Intersection, vehicleRequest: VehicleRequest) =
      Direction.leftDirection(vehicleRequest.incoming) == vehicleRequest.outgoing

    override def signal: Signal = Green
  }

  private def OppositeDirectionTurnSignalSystem: SignalSystem[Intersection, VehicleRequest, Signal] = new SignalSystem[Intersection, VehicleRequest, Signal]{

    def isApplied(intersection: Intersection, vehicleRequest: VehicleRequest) =
      Direction.oppositeDirection(vehicleRequest.incoming) == vehicleRequest.outgoing &&
        isVehicleOnRemainingRoads(intersection, leftRightRoads(intersection, vehicleRequest))

    override def signal: Signal = Red
  }

  private def RightDirectionTurnSignalSystem: SignalSystem[Intersection, VehicleRequest, Signal] = new SignalSystem[Intersection, VehicleRequest, Signal]{

    def isApplied(intersection: Intersection, vehicleRequest: VehicleRequest) =
      Direction.rightDirection(vehicleRequest.incoming) == vehicleRequest.outgoing &&
        isVehicleOnRemainingRoads(intersection, remainingRoads(intersection, vehicleRequest))

    override def signal: Signal = Red
  }

  private def DefaultSignalSystem: SignalSystem[Intersection, VehicleRequest, Signal] = new SignalSystem[Intersection, VehicleRequest, Signal]{

    def isApplied(intersection: Intersection, vehicleRequest: VehicleRequest) = false

    override def signal: Signal = Green
  }

  private def remainingRoads(intersection: Intersection, vehicleRequest: VehicleRequest) =
    intersection.remainingRoadsFor(vehicleRequest.incoming)

  private def leftRightRoads(intersection: Intersection, vehicleRequest: VehicleRequest) =
    intersection.leftRightRoadsFor(vehicleRequest.incoming)

  private def isVehicleOnRemainingRoads(intersection: Intersection, remainingLanes: Seq[Road]) = {
    remainingLanes.exists(_.leftLane.hasVehicle)
  }
}
