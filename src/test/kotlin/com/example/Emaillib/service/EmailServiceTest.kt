/*
package com.example.emaillib.service

import com.example.emaillib.model.EmailLog
import com.example.emaillib.model.ErrorLog
import com.example.emaillib.model.Recipient
import com.example.emaillib.repository.EmailLogRepository
import com.example.emaillib.repository.RecipientRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.mockito.Mockito.any // Правильный импорт статического метода

class EmailServiceTest {

    @Mock
    private lateinit var mailSender: JavaMailSender

    @Mock
    private lateinit var recipientRepository: RecipientRepository

    @Mock
    private lateinit var emailLogRepository: EmailLogRepository

    @InjectMocks
    private lateinit var emailService: EmailService

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test sendErrorEmails`() {
        val errorLog = ErrorLog(batchName = "TestBatch", errorType = "TEST_ERROR", errorMessage = "Test error")
        val recipient = Recipient(id = 1, name = "John Doe", email = "john.doe@example.com", batchName = "TestBatch", errorType = "TEST_ERROR")

        `when`(recipientRepository.findByBatchNameAndErrorType(errorLog.batchName, errorLog.errorType)).thenReturn(listOf(recipient))

        emailService.sendErrorEmails(errorLog)

        verify(mailSender).send(any(SimpleMailMessage::class.java))
        verify(emailLogRepository).save(any(EmailLog::class.java))
    }
}
*/
