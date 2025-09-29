package com.example.projeto_spring.services

import com.example.projeto_spring.api.dto.request.MovimentacaoRequestDto
import com.example.projeto_spring.exceptions.CustomResourceNotFoundException
import com.example.projeto_spring.models.entities.Movimentacao
import com.example.projeto_spring.models.entities.Produto
import com.example.projeto_spring.repositories.MovimentacaoRepository
import com.example.projeto_spring.repositories.ProdutoRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class MovimentacaoService(
    private val movimentacaoRepository: MovimentacaoRepository,
    private val produtoRepository: ProdutoRepository
) {

    fun findAll(): List<Movimentacao> {
        return movimentacaoRepository.findAll()
    }

    fun find(id: Long): Movimentacao {
        return movimentacaoRepository.findById(id)
            .orElseThrow{ CustomResourceNotFoundException() }
    }

    fun create(requestDto: MovimentacaoRequestDto): Movimentacao {
        val produtoEntity: Produto = produtoRepository.findById(requestDto.produtoId)
            .orElseThrow{ CustomResourceNotFoundException() }
        val movimentacaoEntity = Movimentacao(
            fluxo=requestDto.fluxo,
            quantidade = requestDto.quantidade,
            data = LocalDateTime.now(),
            produto = produtoEntity
        )
        return movimentacaoRepository.save(movimentacaoEntity)
    }

    fun update(id: Long, requestDto: MovimentacaoRequestDto): Movimentacao {

        val produtoEntity = produtoRepository.findById(requestDto.produtoId)
            .orElseThrow{CustomResourceNotFoundException()}

        val movimentacaoEntity = movimentacaoRepository.findById(id)
            .orElseThrow{CustomResourceNotFoundException()}

        movimentacaoEntity.fluxo = requestDto.fluxo
        movimentacaoEntity.quantidade = requestDto.quantidade
        movimentacaoEntity.produto = produtoEntity

        return movimentacaoRepository.save(movimentacaoEntity)
    }

    fun delete(id: Long) {
        val movimentacaoEntity = movimentacaoRepository.findById(id)
            .orElseThrow{CustomResourceNotFoundException()}
        movimentacaoRepository.delete(movimentacaoEntity)
    }
}