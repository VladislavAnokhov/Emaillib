package com.example.Emaillib

import com.example.Emaillib.model.ErrorLog
import com.example.Emaillib.repository.EmailLogRepository
import com.example.Emaillib.repository.ErrorLogRepository
import com.example.Emaillib.repository.RecipientRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.slf4j.LoggerFactory

@Configuration
@Profile("test")
class TestConfiguration {

    private val log = LoggerFactory.getLogger(TestConfiguration::class.java)

    @Bean
    fun runTest(emailLogRepository: EmailLogRepository,
                errorLogRepository: ErrorLogRepository,
                recipientRepository: RecipientRepository
    ) = CommandLineRunner {
        // Вставка тестовых данных
        val errorLog = ErrorLog(batchName = "TestBatch", errorType = "TEST_ERROR", errorMessage = "This is a test error")
        errorLogRepository.save(errorLog)

        // Логирование данных для проверки
        log.info("Error log saved: {}", errorLogRepository.findAll())
    }
}
