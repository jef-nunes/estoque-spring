package com.example.projeto_spring.api.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull

data class MovimentacaoRequestDto(

    @field:NotBlank(message = "O fluxo é obrigatório.")
    val fluxo: String,

    @field:Min(value = 1, message = "A quantidade deve ser pelo menos 1.")
    val quantidade: Int,

    @field:NotNull(message = "O produtoId não pode ser nulo.")
    val produtoId: Long
)
