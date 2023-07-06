package com.cubetiq.checkconnection

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import kotlin.system.exitProcess

@Component
class AppRunner(
        private val appProperties: AppProperties,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val schUrl = appProperties.taskUrl()
        val isConnected = checkConnection(url = schUrl)
        if (isConnected) {
            println("Application of url $schUrl is running.")
        } else {
            println("Application of url $schUrl is not running.")
            exitProcess(0)
        }
    }

    companion object {
        fun checkConnection(url: String): Boolean {
            return try {
                val restTemplate = RestTemplate()
                val response = restTemplate.getForObject(url, String::class.java)
                response != null
            } catch (e: Exception) {
                false
            }
        }
    }
}