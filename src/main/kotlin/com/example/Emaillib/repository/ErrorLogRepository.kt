package com.example.Emaillib.repository

import com.example.Emaillib.model.ErrorLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ErrorLogRepository : JpaRepository<ErrorLog, Long>