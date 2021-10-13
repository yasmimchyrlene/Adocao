package com.ong.adocao.controller

import com.ong.adocao.model.Adocao
import com.ong.adocao.service.AdocaoService
import com.ong.adocao.utils.AdocaoUtils
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import kotlin.math.log

@RestController
@RequestMapping(value = ["/adocao"])
@Api(value = "API REST Adoção")
class AdocaoController {

    var logger: Logger = LoggerFactory.getLogger(AdocaoController::class.java)

    @Autowired
    lateinit var adocaoService: AdocaoService

    @PostMapping
    @ApiOperation(value = "Cadastra um animal")

    fun create(@RequestBody adocao: Adocao): ResponseEntity<Any>{
        logger.info("Cadastro recebido",adocao)
        this.adocaoService.create(adocao)
        AdocaoUtils.validation(adocao)
        logger.info("Retornando cadastro {}",adocao)
        return ResponseEntity(adocao, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Altera dados de um animal")
    fun update(@PathVariable id: Long, @RequestBody adocao: Adocao): ResponseEntity<Any> {
        logger.info("Atualização recebida {}",adocao)
        this.adocaoService.update(id, adocao)
        AdocaoUtils.validation(adocao)
        return ResponseEntity(Unit,HttpStatus.OK)
    }

    @GetMapping
    @ApiOperation(value = "Mostra todos os animais")
    fun getAll(): ResponseEntity<Any> {
        var adocao = this.adocaoService.getAll()
        logger.info("Retornando registros")
        return ResponseEntity(adocao, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Mostra um único animal")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        logger.info("ID recebido {}", id)
        var adocao = this.adocaoService.getById(id)
        logger.info("Retornando registro do animal")
        return ResponseEntity(adocao, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta dados de um animal")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        adocaoService.delete(id)
        logger.info("Registro do animal deletado, id: {}", id)
        return ResponseEntity(Unit, HttpStatus.NO_CONTENT)
    }
}
