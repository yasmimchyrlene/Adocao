package com.ong.adocao.service

import com.ong.adocao.model.Adocao

interface AdocaoService {

    fun create(adocao: Adocao)
    fun update(id: Long, adocao: Adocao)
    fun getAll():List<Adocao>
    fun getById(id: Long): Adocao
    fun delete(id: Long)
}