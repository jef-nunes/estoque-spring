package com.example.projeto_spring.models

import jakarta.persistence.*
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