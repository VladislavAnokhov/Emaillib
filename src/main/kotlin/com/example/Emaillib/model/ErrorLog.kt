package com.example.Emaillib.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

import java.time.LocalDateTime


@Entity
data class ErrorLog(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val batchName: String = "",
    val errorType: String = "",
    val errorMessage: String = "",
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(0, "", "", "", LocalDateTime.now())
}
