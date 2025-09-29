package com.example.projeto_spring.api.controllers

import com.example.projeto_spring.api.controllers.util.ResponseBuilder
import com.example.projeto_spring.api.dto.util.ToResponseDto
import com.example.projeto_spring.api.dto.request.MovimentacaoRequestDto
import com.example.projeto_spring.api.dto.response.MovimentacaoResponseDto
import com.example.projeto_spring.models.entities.Movimentacao
import com.example.projeto_spring.models.ResponseModel
import com.example.projeto_spring.services.MovimentacaoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.collections.forEach

@RestController
@RequestMapping("/movimentacoes")
class MovimentacaoController(
    private val movimentacaoService: MovimentacaoService
) {
    @GetMapping
    fun findAll(): ResponseEntity<ResponseModel<MovimentacaoResponseDto>> {
        val entityList: List<Movimentacao> = movimentacaoService.findAll()
        val responseDtoList: MutableList<MovimentacaoResponseDto> = mutableListOf()
        entityList.forEach {
                entity ->
            val responseDto: MovimentacaoResponseDto = ToResponseDto.movimentacao(entity)
            responseDtoList.add(responseDto)
        }
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseBuilder.buildSuccessResponse(responseDtoList))
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long):  ResponseEntity<ResponseModel<MovimentacaoResponseDto>>  {
        val entity: Movimentacao = movimentacaoService.find(id)
        val responseDto: MovimentacaoResponseDto = ToResponseDto.movimentacao(entity)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseBuilder.buildSuccessResponse(mutableListOf(responseDto)))
    }

    @PostMapping
    fun create(@Valid @RequestBody requestDto: MovimentacaoRequestDto):  ResponseEntity<ResponseModel<MovimentacaoResponseDto>>  {
        val entity = movimentacaoService.create(requestDto)
        val responseDto: MovimentacaoResponseDto = ToResponseDto.movimentacao(entity)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ResponseBuilder.buildSuccessResponse(mutableListOf(responseDto)))
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @Valid @RequestBody requestDto: MovimentacaoRequestDto
    ): ResponseEntity<ResponseModel<MovimentacaoResponseDto>> {
        val entity = movimentacaoService.update(id, requestDto)
        val responseDto: MovimentacaoResponseDto = ToResponseDto.movimentacao(entity)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseBuilder.buildSuccessResponse(mutableListOf(responseDto)))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long):  ResponseEntity<ResponseModel<MovimentacaoResponseDto>>  {
        movimentacaoService.delete(id)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ResponseBuilder.buildSuccessResponse())
    }
}