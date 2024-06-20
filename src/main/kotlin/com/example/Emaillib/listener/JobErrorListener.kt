package com.example.Emaillib.listener

import com.example.Emaillib.model.ErrorLog
import com.example.Emaillib.repository.ErrorLogRepository
import com.example.Emaillib.service.EmailService
import org.springframework.batch.core.BatchStatus
import org.springframework.batch.core.JobExecution
import org.springframework.batch.core.JobExecutionListener
import org.springframework.stereotype.Component

@Component
class JobErrorListener (
    private val emailService: EmailService,
    private val errorLogRepository: ErrorLogRepository
): JobExecutionListener{

    override fun afterJob(jobExecution: JobExecution){
        if (jobExecution.status==BatchStatus.FAILED){
            val exception = jobExecution.allFailureExceptions.joinToString { it.message ?: "Unknown error "}
            val errorLog = ErrorLog (
                batchName = jobExecution.jobInstance.jobName,
                errorType = "JOB_FAILURE",
                errorMessage = exception
            )
            errorLogRepository.save(errorLog)
            emailService.sendErrorEmails(errorLog)
        }
    }
}
