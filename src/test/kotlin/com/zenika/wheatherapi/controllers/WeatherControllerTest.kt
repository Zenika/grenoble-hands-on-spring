package com.zenika.wheatherapi.controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class WeatherControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `it should return expected weather`() {
        mockMvc.get("/api/weather/grenoble")
            .andExpect {
                status { isOk() }
                content { string("fine") }
            }
    }
}