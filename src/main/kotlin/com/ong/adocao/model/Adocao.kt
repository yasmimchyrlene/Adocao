package com.ong.adocao.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Adocao(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val raca: String = "",
        val cor: String = "",
        val porte: String = "",

        )