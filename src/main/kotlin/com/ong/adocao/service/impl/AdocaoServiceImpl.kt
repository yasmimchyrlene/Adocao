package com.ong.adocao.service.impl

import com.ong.adocao.model.Adocao
import com.ong.adocao.repository.AdocaoRepository
import com.ong.adocao.service.AdocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdocaoServiceImpl: AdocaoService {
    @Autowired
    lateinit var adocaoRepository: AdocaoRepository

    override fun create(adocao: Adocao) {
        adocaoRepository.save(adocao)
    }

    override fun update(id: Long, adocao: Adocao) {
        adocaoRepository.save(Adocao(id, adocao.raca, adocao.cor, adocao.sexo, adocao.porte,
                adocao.idade, adocao.castrado))
    }

    override fun getAll(): List<Adocao> {
        return this.adocaoRepository.findAll().toList()
    }

    override fun getById(id: Long): Adocao {
        return this.adocaoRepository.findById(id).orElse(null)
    }

    override fun delete(id: Long) {
        return this.adocaoRepository.deleteById(id)
    }


}