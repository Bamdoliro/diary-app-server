package com.app.diary

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class DiaryApplication

fun main(args: Array<String>) {
	runApplication<DiaryApplication>(*args)
}
