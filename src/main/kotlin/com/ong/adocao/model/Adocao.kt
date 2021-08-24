package com.ong.adocao.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Adocao(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val raca: String = "",
        val cor: String = "",
        val sexo: String = "",
        val porte: String = "",
        val idade: Int,
        val castrado: Boolean = true,

        )