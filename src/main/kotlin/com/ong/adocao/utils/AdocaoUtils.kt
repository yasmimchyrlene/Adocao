package com.ong.adocao.utils

import com.ong.adocao.controller.handler.exception.BadRequestException
import com.ong.adocao.model.Adocao
import org.springframework.util.ObjectUtils

class AdocaoUtils {

    companion object {
        fun validation(adocao: Adocao): Adocao {
            isRaca(adocao.raca)
            isCor(adocao.cor)
            isSexo(adocao.sexo)
            isPorte(adocao.porte)
            isIdade(adocao.idade)
            return adocao
        }

        private fun isRaca(raca: String) {
            if (ObjectUtils.isEmpty(raca)) {
                throw BadRequestException("Precisa de um nome válido")
            }
        }

        private fun isCor(cor: String) {
            if (ObjectUtils.isEmpty(cor)) {
                throw BadRequestException("Cor inválida")
            }
        }

        private fun isSexo(sexo: String) {
            if (ObjectUtils.isEmpty(sexo)) {
                throw BadRequestException("Sexo inválido")
            }
        }
        private fun isIdade(idade: Int) {
            if (idade <= 0) {
                throw BadRequestException("Idade inválida")
            }
        }
        private fun isPorte(porte: String) {
            if (ObjectUtils.isEmpty(porte)) {
                throw BadRequestException("Porte inválido")
            }
        }
    }
}