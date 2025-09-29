package com.example.projeto_spring.api.controllers

import com.example.projeto_spring.api.controllers.util.ResponseBuilder
import com.example.projeto_spring.api.dto.util.ToResponseDto
import com.example.projeto_spring.api.dto.request.ProdutoRequestDto
import com.example.projeto_spring.api.dto.response.ProdutoResponseDto
import com.example.projeto_spring.models.entities.Produto
import com.example.projeto_spring.models.ResponseModel
import com.example.projeto_spring.services.ProdutoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/produtos")
class ProdutoController(
    private val produtoService: ProdutoService
) {

    @GetMapping
    fun findAll(): ResponseEntity<ResponseModel<ProdutoResponseDto>> {
        val entityList: List<Produto> = produtoService.findAll()
        val responseDtoList: MutableList<ProdutoResponseDto> = mutableListOf()
        entityList.forEach {
            entity ->
            val responseDto: ProdutoResponseDto = ToResponseDto.produto(entity)
            responseDtoList.add(responseDto)
        }
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseBuilder.buildSuccessResponse(responseDtoList))
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long):  ResponseEntity<ResponseModel<ProdutoResponseDto>>  {
        val entity: Produto = produtoService.find(id)
        val responseDto: ProdutoResponseDto = ToResponseDto.produto(entity)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseBuilder.buildSuccessResponse(mutableListOf(responseDto)))
    }

    @PostMapping
    fun create(@Valid @RequestBody requestDto: ProdutoRequestDto):  ResponseEntity<ResponseModel<ProdutoResponseDto>>  {
        val entity = produtoService.create(requestDto)
        val responseDto: ProdutoResponseDto = ToResponseDto.produto(entity)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ResponseBuilder.buildSuccessResponse(mutableListOf(responseDto)))
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody requestDto: ProdutoRequestDto
    ): ResponseEntity<ResponseModel<ProdutoResponseDto>> {
        val entity = produtoService.update(id, requestDto)
        val responseDto: ProdutoResponseDto = ToResponseDto.produto(entity)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseBuilder.buildSuccessResponse(mutableListOf(responseDto)))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long):  ResponseEntity<ResponseModel<ProdutoResponseDto>>  {
        produtoService.delete(id)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseBuilder.buildSuccessResponse())
    }
}
