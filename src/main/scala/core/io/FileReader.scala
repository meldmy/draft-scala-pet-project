package io

import java.io.{FileInputStream, InputStream}

import core.graph.MixingMethodApp.{ConsoleLogger, Logged}

/**
  * @author Dmytro Melnychuk
  */
trait Buffered extends InputStream with Logged{
  val SIZE = 1024
  private var end = 0
  private val buffer = new Array[Byte](SIZE)
  private var pos = 0

  override def read() = {
    if (pos == end) {
      log("Buffer reading start")
      end = super.read(buffer, 0, SIZE)
      pos = 0
    }
    if (pos == end) -1 else {
      pos += 1
      buffer(pos - 1)
    }
  }
}

object FileReaderApp extends App{

  private val inputStream = new FileInputStream("/usr/share/dict/words") with Buffered with ConsoleLogger
  println(inputStream.read())
  println(inputStream.read())
  println(inputStream.read())
}
