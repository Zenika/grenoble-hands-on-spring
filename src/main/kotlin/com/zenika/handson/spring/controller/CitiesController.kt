package com.zenika.handson.spring.controller

import com.zenika.handson.spring.repositories.CitiesRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cities")
class CitiesController(private val cityRepository: CitiesRepository) {

    @GetMapping
    fun geCities() = cityRepository.findAll()

    @GetMapping("/{name}")
    fun getCity(@PathVariable name: String) = cityRepository.getByName(name)
        ?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}