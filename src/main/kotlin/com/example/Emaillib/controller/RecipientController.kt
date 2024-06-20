package com.example.Emaillib.controller

import com.example.Emaillib.model.ErrorLog
import com.example.Emaillib.model.Recipient
import com.example.Emaillib.repository.ErrorLogRepository
import com.example.Emaillib.repository.RecipientRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/recipient")
class RecipientController (
    private val recipientRepository: RecipientRepository,
    private val errorLogRepository: ErrorLogRepository
){
    @GetMapping
    fun getAllRecipients():List<Recipient> = recipientRepository.findAll()
    @PostMapping
    fun addRecipient (@RequestBody recipient: Recipient): Recipient =recipientRepository.save(recipient)
    @GetMapping("/error-logs")
    fun getAllErrorLogs(): List<ErrorLog> {
        return errorLogRepository.findAll()
    }
}
