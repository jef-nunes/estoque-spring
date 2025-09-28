package com.example.projeto_spring.api.dto.response

data class ProdutoResponseDto(
    val id: Long,
    val nome: String?,
    val marca: String?,
    val quantidadeDisponivel: Int?,
    val preco: Double?,
    val movimentacaoIdList: MutableList<Long>
)
