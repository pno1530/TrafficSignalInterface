package app.com.org.domain

sealed abstract class Signal

case object Red extends Signal
case object Green extends Signal