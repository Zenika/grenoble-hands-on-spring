package com.zenika.handson.spring.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import org.springframework.transaction.annotation.Transactional

@WebMvcTest(controllers = [CitiesController::class])
@AutoConfigureDataJpa
@Transactional
@Sql(scripts = ["/sql/init-cities.sql"])
internal class CitiesControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `get all cities return 200`() {
        mockMvc.get("/cities")
            .andExpect { status { isOk() } }
            .andExpect {
                content {
                    json(javaClass.getResource("/contract/cities/GET_CITIES.json").readText())
                }
            }
    }

    @Test
    fun `get existing city return 200`() {
        mockMvc.get("/cities/GRENOBLE")
            .andExpect { status { isOk() } }
            .andExpect {
                content {
                    json(javaClass.getResource("/contract/cities/GET_CITY.json").readText())
                }
            }
    }

    @Test
    @WithMockUser(username = "ADMIN", roles = ["ADMIN"])
    fun `add new city return 201`() {
        mockMvc.post("/cities") {
             contentType = MediaType.APPLICATION_JSON
             content = javaClass.getResource("/contract/cities/POST_CITY.json").readText()
        }
            .andExpect { status { isCreated() } }
            .andExpect {
                content {
                    json(javaClass.getResource("/contract/cities/POST_CITY.json").readText())
                }
            }
    }

    @Test
    fun `add new city without login return 401`() {
        mockMvc.post("/cities") {
            contentType = MediaType.APPLICATION_JSON
            content = javaClass.getResource("/contract/cities/POST_CITY.json").readText()
        }
            .andExpect { status { isForbidden() } }
    }

    @Test
    fun `add invalid city return 400`() {
        mockMvc.post("/cities") {
            contentType = MediaType.APPLICATION_JSON
            content = javaClass.getResource("/contract/cities/POST_INVALID_CITY.json").readText()
        }
            .andExpect { status { is4xxClientError() } }
    }

    @Test
    fun `get unknown city return 404`() {
        mockMvc.get("/cities/NOWHERE")
            .andExpect { status { isNotFound() } }
    }

}