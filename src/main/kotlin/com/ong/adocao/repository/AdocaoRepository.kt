package com.ong.adocao.repository

import com.ong.adocao.model.Adocao
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AdocaoRepository: CrudRepository<Adocao, Long> {
}