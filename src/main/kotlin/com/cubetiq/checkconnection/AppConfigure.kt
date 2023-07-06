package com.cubetiq.checkconnection

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class AppConfigure {
    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}