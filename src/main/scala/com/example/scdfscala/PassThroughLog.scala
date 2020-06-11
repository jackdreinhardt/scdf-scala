package com.example.scdfscala

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.stream.annotation.{EnableBinding, StreamListener}
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.messaging.handler.annotation.SendTo

@SpringBootApplication
@EnableBinding(classOf[Processor])
class PassThroughLog {

  @StreamListener(value = "input")
  @SendTo(Array("output"))
  def passthroughlog(input: String): String = {
    println(s"Received input `$input`")
    input
  }
}

object PassThroughLog {
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[PassThroughLog], args: _*)
}