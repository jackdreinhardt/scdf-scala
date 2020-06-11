package com.example.scdfscala.source

import java.util.function.Supplier

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class HelloWorld {

  @Bean
  def helloworld2(): Supplier[String] = () => "Hello World"
}

object HelloWorld {
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[HelloWorld], args: _ *)
}