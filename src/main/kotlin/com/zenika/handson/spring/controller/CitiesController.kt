package com.zenika.handson.spring.controller

import com.zenika.handson.spring.entities.City
import com.zenika.handson.spring.repositories.CitiesRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/cities")
class CitiesController(private val cityRepository: CitiesRepository) {

    @GetMapping
    fun geCities() = cityRepository.findAll()

    @GetMapping("/{name}")
    fun getCity(@PathVariable name: String) = cityRepository.getByName(name)
        ?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping()
    fun addCity(@Valid @RequestBody city: City) = cityRepository.save(city)
        .let { ResponseEntity.status(HttpStatus.CREATED).body(it) }

}