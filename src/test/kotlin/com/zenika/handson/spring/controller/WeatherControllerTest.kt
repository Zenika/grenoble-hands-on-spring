package com.zenika.handson.spring.controller

import com.zenika.handson.spring.repositories.inmemory.WeatherRepositoryInMemory
import com.zenika.handson.spring.services.WeatherService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.transaction.annotation.Transactional

@WebMvcTest(controllers = [WeatherController::class])
@AutoConfigureDataJpa
@Transactional
@Sql(scripts = ["/sql/init-cities.sql"])
@Import(value = [WeatherService::class, WeatherRepositoryInMemory::class])
internal class WeatherControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `get weather for known city return 200`() {
        mockMvc.get("/cities/GRENOBLE/weather")
            .andExpect { status { isOk() } }
            .andExpect {
                content {
                    json(javaClass.getResource("/contract/weather/GET_DAILY_WEATHER.json").readText())
                }
            }
    }

    @Test
    fun `get weather for unknown city return 404`() {
        mockMvc.get("/cities/{cityId}/weather", "NOWHERE")
            .andExpect {
                status { isNotFound() }
            }
    }
}
