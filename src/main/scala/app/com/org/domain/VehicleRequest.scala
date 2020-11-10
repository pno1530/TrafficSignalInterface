package app.com.org.domain

sealed case class VehicleRequest(incoming: Direction, outgoing: Direction)