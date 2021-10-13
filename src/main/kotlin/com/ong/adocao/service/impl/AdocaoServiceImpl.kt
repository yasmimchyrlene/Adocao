package com.ong.adocao.service.impl

import com.ong.adocao.controller.handler.exception.NotFoundException
import com.ong.adocao.model.Adocao
import com.ong.adocao.repository.AdocaoRepository
import com.ong.adocao.service.AdocaoService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdocaoServiceImpl: AdocaoService {

    var logger: Logger = LoggerFactory.getLogger(AdocaoServiceImpl::class.java)

    @Autowired
    lateinit var adocaoRepository: AdocaoRepository

    override fun create(adocao: Adocao): Adocao {
        adocaoRepository.save(adocao)
        logger.info("Adoção cadastrada com sucesso")
        return adocao
    }

    override fun update(id: Long, adocao: Adocao) {
        adocaoRepository.save(Adocao(id, adocao.raca, adocao.cor, adocao.sexo, adocao.porte,
                adocao.idade, adocao.castrado))
        logger.info("Cadastro atualizado com sucesso")
    }

    override fun getAll(): List<Adocao> {
        var adocao = this.adocaoRepository.findAll().toList()
        logger.info("Busca realizada com sucesso")
        return adocao
    }

    override fun getById(id: Long): Adocao {
        var adocao = adocaoRepository.findById(id).orElseThrow { NotFoundException("Registro não encontrado") }
        logger.info("Registro encontrado")
        return adocao
    }

    override fun delete(id: Long) {
        try {
            this.adocaoRepository.deleteById(id)
        } catch (ex: Exception){
            logger.error("ID não encontrado")
        }
    }
}