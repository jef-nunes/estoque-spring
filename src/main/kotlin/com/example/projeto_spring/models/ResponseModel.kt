package com.example.projeto_spring.models

import java.time.LocalDateTime

data class ResponseModel<T>(
    val status: String?,
    val data: MutableList<T>?,
    val timestamp: LocalDateTime?,
    val errors: MutableList<String?>?
)