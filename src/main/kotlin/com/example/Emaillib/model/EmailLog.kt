package com.example.Emaillib.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class EmailLog(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val recipientEmail: String = "",
    val batchName: String = "",
    val errorType: String = "",
    val emailContent: String = "",
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(0, "", "", "", "", LocalDateTime.now())
}
