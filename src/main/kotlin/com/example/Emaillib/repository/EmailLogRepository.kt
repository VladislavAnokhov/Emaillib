package com.example.Emaillib.repository

import com.example.Emaillib.model.EmailLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmailLogRepository : JpaRepository<EmailLog, Long>