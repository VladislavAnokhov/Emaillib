package com.example.Emaillib.service

import com.example.Emaillib.model.EmailLog
import com.example.Emaillib.model.ErrorLog
import com.example.Emaillib.repository.EmailLogRepository
import com.example.Emaillib.repository.RecipientRepository
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService (
    private val mailSender: JavaMailSender,
    private val recipientRepository: RecipientRepository,
    private val emailLogRepository: EmailLogRepository
    ) {
    fun sendErrorEmails(errorLog: ErrorLog) {
        val recipients = recipientRepository.findByBatchNameAndErrorType(errorLog.batchName, errorLog.errorType)
        recipients.forEach { recipient ->
            val emailContent = "Error in batch ${errorLog.batchName}: ${errorLog.errorMessage}"
            sendEmail(recipient.email, "Batch Error Notification", emailContent)
            emailLogRepository.save(
                EmailLog(
                recipientEmail = recipient.email,
                batchName = errorLog.batchName,
                errorType = errorLog.errorType,
                emailContent = emailContent
            )
            )
        }
}
    private fun sendEmail(to: String, subject: String, content: String){
        val message = SimpleMailMessage()
        message.setTo(to)
        message.subject = subject
        message.text = content
        mailSender.send(message)

    }    }