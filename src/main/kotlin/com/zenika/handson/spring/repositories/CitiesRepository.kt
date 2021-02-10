package com.zenika.handson.spring.repositories

import com.zenika.handson.spring.entities.City

interface CitiesRepository {
    fun findAll(): List<City>
    fun getByName(name: String): City?
    fun save(city: City): City
}