package app.com.org.domain

trait Error

case object InvalidFile extends Error
case object InvalidNorthLaneInput extends Error
case object InvalidSouthLaneInput extends Error
case object InvalidWestLaneInput extends Error
case object InvalidEastLaneInput extends Error