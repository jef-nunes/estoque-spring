package com.example.projeto_spring.api.dto.util

import com.example.projeto_spring.api.dto.response.MovimentacaoResponseDto
import com.example.projeto_spring.api.dto.response.ProdutoResponseDto
import com.example.projeto_spring.models.Movimentacao
import com.example.projeto_spring.models.Produto

object ToResponseDto {
    fun produto(entity: Produto): ProdutoResponseDto {
        val movimentacaoIdList: MutableList<Long> = mutableListOf()
        entity.movimentacoes.forEach {
            movimentacaoEntity ->
            movimentacaoIdList.add(movimentacaoEntity.id!!)
        }
        val responseDto = ProdutoResponseDto(
            entity.id!!,
            entity.nome,
            entity.marca,
            entity.quantidadeDisponivel,
            entity.preco,
            movimentacaoIdList
        )
        return responseDto
    }

    fun movimentacao(entity: Movimentacao): MovimentacaoResponseDto {
        val produtoId: Long = entity.produto.id!!
        val responseDto = MovimentacaoResponseDto(
            entity.id!!,
            entity.fluxo,
            entity.quantidade,
            entity.data,
            produtoId
        )
        return responseDto
    }
}