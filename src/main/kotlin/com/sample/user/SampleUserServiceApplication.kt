package com.sample.user

import com.sample.user.config.ClientApiConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@EnableConfigurationProperties(ClientApiConfig::class)
@SpringBootApplication
class SampleUserServiceApplication

fun main(args: Array<String>) {
	runApplication<SampleUserServiceApplication>(*args)
}
