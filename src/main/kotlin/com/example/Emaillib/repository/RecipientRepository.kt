package com.example.Emaillib.repository

import com.example.Emaillib.model.Recipient
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipientRepository : JpaRepository<Recipient, Long> {
    fun findByBatchNameAndErrorType(batchName: String, errorType: String): List<Recipient>
}