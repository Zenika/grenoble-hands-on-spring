package com.zenika.wheatherapi.seeds

import com.zenika.wheatherapi.model.City
import com.zenika.wheatherapi.model.GeoPosition
import com.zenika.wheatherapi.repositories.CityRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("dev")
class InitData(val cityRepository: CityRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        listOf(
            City("lyon","Lyon", GeoPosition(3.0, 47.0)),
            City("grenoble","Grenoble", GeoPosition(5.0, 45.0)),
            City("chambery","Chambéry", GeoPosition(5.0, 47.0)),
        ).forEach {
            if (!cityRepository.existsById(it.name)) cityRepository.save(it)
        }
    }
}