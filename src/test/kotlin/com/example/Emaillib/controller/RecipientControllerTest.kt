/*
package com.example.Emaillib.controller


import com.example.Emaillib.model.Recipient
import com.example.Emaillib.repository.RecipientRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@ExtendWith(SpringExtension::class, MockitoExtension::class)
@WebMvcTest(RecipientController::class)
@AutoConfigureMockMvc
class RecipientControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc
    @MockBean
    private lateinit var recipientController: RecipientController

    @MockBean
    private lateinit var recipientRepository: RecipientRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testAddRecipient() {
        val recipientJson = """
            {
                "name": "John Doe",
                "email": "john.doe@example.com"
            }
        """.trimIndent()

        mockMvc.perform(post("/recipient")
            .contentType(MediaType.APPLICATION_JSON)
            .content(recipientJson))
            .andExpect(status().isOk)
    }

}
*/
