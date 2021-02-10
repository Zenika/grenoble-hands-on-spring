package com.zenika.handson.spring.repositories.jpa

import com.zenika.handson.spring.entities.City
import com.zenika.handson.spring.repositories.CitiesRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CitiesRepositoryJpa : CrudRepository<City, String>, CitiesRepository