package app.com.org.App

import app.com.org.domain._
import app.com.org.service.Interpreter.TrafficSignallingSystemInterpreter

object App {

  def main(args: Array[String]): Unit = {
    val filePath1 = "test/resources/State1.txt"
    val filePath2 = "test/resources/State2.txt"
    val filePath3 = "test/resources/State3.txt"
    val filePath4 = "test/resources/State4.txt"
    val filePath5 = "test/resources/State5.txt"
    val filePath6 = "test/resources/State6.txt"

    val filePaths = List(filePath1, filePath2, filePath3, filePath4, filePath5, filePath6)
    println("output-- " + filePaths.map(f => (new TrafficSignallingSystemInterpreter {}).execute(f, VehicleRequest(North, East))))
  }

}

object common{
  type VehicleId = Int
}