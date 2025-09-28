package com.example.projeto_spring.services

import com.example.projeto_spring.api.dto.request.ProdutoRequestDto
import com.example.projeto_spring.exceptions.CustomResourceNotFoundException
import com.example.projeto_spring.models.Produto
import com.example.projeto_spring.repositories.ProdutoRepository
import org.springframework.stereotype.Service

@Service
class ProdutoService(
    private val produtoRepository: ProdutoRepository
) {

    fun findAll(): List<Produto> {
        return produtoRepository.findAll()
    }

    fun find(id: Long): Produto {
        return produtoRepository.findById(id)
            .orElseThrow{ CustomResourceNotFoundException() }
    }

    fun create(requestDto: ProdutoRequestDto): Produto {
        val entity = Produto(
            nome = requestDto.nome,
            marca = requestDto.marca,
            quantidadeDisponivel = requestDto.quantidadeDisponivel,
            preco = requestDto.preco
        )
        return produtoRepository.save(entity)
    }

    fun update(id: Long, requestDto: ProdutoRequestDto): Produto {
        val entity = produtoRepository.findById(id)
            .orElseThrow{ CustomResourceNotFoundException() }

        entity.nome = requestDto.nome
        entity.marca = requestDto.marca
        entity.quantidadeDisponivel = requestDto.quantidadeDisponivel
        entity.preco = requestDto.preco

        return produtoRepository.save(entity)
    }

    fun delete(id: Long) {
        val entity = produtoRepository.findById(id)
            .orElseThrow{ CustomResourceNotFoundException() }
        produtoRepository.delete(entity)
    }
}
