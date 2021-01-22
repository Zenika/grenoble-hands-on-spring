package com.zenika.wheatherapi.controllers

import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(controllers = [CityController::class])
internal class CityControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should receive expected payload`() {
        mockMvc.get("/api/cities")
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$", hasSize<Any>(2))
                jsonPath("$[0].name", `is`("Grenoble"))
                jsonPath("$[0].position.latitude", `is`(5.0))
                jsonPath("$[0].position.longitude", `is`(45.0))
                jsonPath("$[1].name", `is`("Lyon"))
                jsonPath("$[1].position.latitude", `is`(3.0))
                jsonPath("$[1].position.longitude", `is`(47.0))
            }

    }
}