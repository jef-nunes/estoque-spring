package com.example.projeto_spring.models.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    var nome: String? = "",

    var marca: String? = "",

    var quantidadeDisponivel: Int? = 0,

    var preco: Double? = 0.0,

    @OneToMany(mappedBy = "produto", cascade = [CascadeType.PERSIST], orphanRemoval = true)
    var movimentacoes: MutableList<Movimentacao> = mutableListOf()
)