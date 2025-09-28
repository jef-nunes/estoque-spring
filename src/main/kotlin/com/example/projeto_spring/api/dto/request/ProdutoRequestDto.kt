package com.example.projeto_spring.api.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import org.hibernate.validator.constraints.Length

data class ProdutoRequestDto(

    @field:NotBlank(message = "O nome é obrigatório.")
    @field:Length(max=255, message = "O comprimento máximo do nome é 255 caracteres")
    val nome: String,

    @field:Length(max=255, message = "O comprimento máximo da marca é 255 caracteres")
    val marca: String,

    @field:PositiveOrZero(message = "A quantidade deve ser um valor positivo ou zero.")
    val quantidadeDisponivel: Int,

    @field:Positive(message = "O preço deve ser um valor positivo.")
    val preco: Double?

)
