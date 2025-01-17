package com.funtikov.lcinema

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CinemaLoveApplication

fun main(args: Array<String>) {
    SpringApplication.run(CinemaLoveApplication::class.java, *args)
}
