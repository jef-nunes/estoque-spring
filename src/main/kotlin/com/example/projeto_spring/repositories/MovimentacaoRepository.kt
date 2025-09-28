package com.example.projeto_spring.repositories

import com.example.projeto_spring.models.Movimentacao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovimentacaoRepository : JpaRepository<Movimentacao, Long>