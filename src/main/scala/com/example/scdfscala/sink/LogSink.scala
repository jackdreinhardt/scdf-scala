package com.example.scdfscala.sink

import java.util.function.Consumer

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication
class LogSink {

  @Bean
  def logsink(): Consumer[String] = {
    input: String => println(input)
  }
}

object LogSink {
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[LogSink], args: _ *)
}