package ru.dartinc.rhmkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RhmkotlinApplication

fun main(args: Array<String>) {
	runApplication<RhmkotlinApplication>(*args)
}
