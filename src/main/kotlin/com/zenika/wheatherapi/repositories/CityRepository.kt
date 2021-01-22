package com.zenika.wheatherapi.repositories

import com.zenika.wheatherapi.model.City
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository: CrudRepository<City, String>, PagingAndSortingRepository<City, String>