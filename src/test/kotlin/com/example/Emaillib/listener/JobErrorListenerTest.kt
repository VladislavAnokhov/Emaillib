/*
package com.example.emaillib.listener

import com.example.emaillib.model.ErrorLog
import com.example.emaillib.repository.ErrorLogRepository
import com.example.emaillib.service.EmailService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobInstance
import org.springframework.batch.core.JobParametersBuilder

@ExtendWith(MockitoExtension::class)
class JobErrorListenerTest {

    @Mock
    private lateinit var emailService: EmailService

    @Mock
    private lateinit var errorLogRepository: ErrorLogRepository

    @InjectMocks
    private lateinit var jobErrorListener: JobErrorListener

    @Test
    fun `test afterJob with job failure`() {
        // Prepare test data
        val jobInstance = JobInstance(1L, "testJob")
        val jobParameters = JobParametersBuilder()
            .addString("param1", "value1")
            .toJobParameters()
            // val job = Mockito.mock(Job::class.java)
        val jobExecution = JobExecution(jobInstance, jobParameters)
        jobExecution.id = 1L
        jobExecution.status = BatchStatus.FAILED
        jobExecution.addFailureException(Exception("Test error"))

        // Mock repository behavior
        Mockito.`when`(errorLogRepository.save(Mockito.any(ErrorLog::class.java)))
            .thenAnswer { invocation ->
                val errorLog = invocation.getArgument(0, ErrorLog::class.java)
                // Handle null case, if needed
                // Perform desired actions or return a mock response
                errorLog
            }

        // Call the method under test
        jobErrorListener.afterJob(jobExecution)

        // Verify interactions
        Mockito.verify(errorLogRepository).save(Mockito.any(ErrorLog::class.java))
            //     Mockito.verify(emailService).sendErrorEmails(Mockito.any(ErrorLog::class.java))
    }

}
*/
