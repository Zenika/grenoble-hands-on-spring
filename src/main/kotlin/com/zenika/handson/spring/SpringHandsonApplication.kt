package com.zenika.handson.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class SpringHandsonApplication

fun main(args: Array<String>) {
    runApplication<SpringHandsonApplication>(*args)
}
