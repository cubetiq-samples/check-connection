package com.cubetiq.checkconnection

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CheckConnectionApplication

fun main(args: Array<String>) {
    runApplication<CheckConnectionApplication>(*args)
}
