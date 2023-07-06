package com.cubetiq.checkconnection

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


@RestController
@RequestMapping
class Controller(
        private val appProperties: AppProperties,
) {
    @GetMapping
    fun index(): Any {
        return mapOf(
                "date" to LocalDateTime.now(),
                "status" to "ok"
        )
    }

    @GetMapping("/connection")
    fun connection(): Any {
        val url = appProperties.taskUrl()
        val isConnected = AppRunner.checkConnection(url)
        var data: Map<String, Any> = mapOf(
                "error" to true,
                "url" to appProperties.taskUrl(),
                "message" to "Connection Fail"
        )

        if (isConnected) {
            data = mapOf(
                    "date" to LocalDateTime.now(),
                    "url" to appProperties.taskUrl(),
                    "message" to "Connection Successful"
            )
        }
        return data
    }
}