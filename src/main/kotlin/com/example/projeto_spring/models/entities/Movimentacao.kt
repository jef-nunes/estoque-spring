package com.example.projeto_spring.models.entities

import com.example.projeto_spring.models.entities.Produto
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Movimentacao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    var fluxo: String = "",

    var quantidade: Int = 0,

    var data: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "produto_id")
    var produto: Produto = Produto()
)