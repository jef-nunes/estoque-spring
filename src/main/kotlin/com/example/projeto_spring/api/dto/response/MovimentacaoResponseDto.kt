package com.example.projeto_spring.api.dto.response

import java.time.LocalDateTime

data class MovimentacaoResponseDto(
    val id: Long,
    val fluxo: String,
    val quantidade: Int,
    val data: LocalDateTime,
    val produtoId: Long,
)
