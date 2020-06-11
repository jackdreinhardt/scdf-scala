package com.example.scdfscala

import java.util.function.Function

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PassThroughLog {

  @Bean
  def passthroughlog(): Function[String, String] = {
    input: String => {
      println(s"Received input `$input`")
      input
    }
  }
}

object PassThroughLog {
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[PassThroughLog], args: _ *)
}