package com.sample.user

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleUserServiceApplication

fun main(args: Array<String>) {
	runApplication<SampleUserServiceApplication>(*args)
}
