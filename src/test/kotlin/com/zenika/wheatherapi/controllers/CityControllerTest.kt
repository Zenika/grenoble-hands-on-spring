package com.zenika.wheatherapi.controllers

import com.zenika.wheatherapi.model.City
import com.zenika.wheatherapi.model.GeoPosition
import com.zenika.wheatherapi.repositories.CityRepository
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class CityControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var cityRepository: CityRepository

    @BeforeEach
    fun initDB() {
        cityRepository.saveAll(
            listOf(
                City("lyon","Lyon", GeoPosition(3.0, 47.0)),
                City("grenoble","Grenoble", GeoPosition(5.0, 45.0)),
            )
        )
    }

    @Test
    fun `should receive expected payload`() {
        mockMvc.get("/api/cities")
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$", hasSize<Any>(2))
                jsonPath("$[0].cityId", `is`("grenoble"))
                jsonPath("$[0].name", `is`("Grenoble"))
                jsonPath("$[0].position.latitude", `is`(5.0))
                jsonPath("$[0].position.longitude", `is`(45.0))
                jsonPath("$[1].cityId", `is`("lyon"))
                jsonPath("$[1].name", `is`("Lyon"))
                jsonPath("$[1].position.latitude", `is`(3.0))
                jsonPath("$[1].position.longitude", `is`(47.0))
            }

    }
}