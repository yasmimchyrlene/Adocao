package com.ong.adocao.controller

import com.ong.adocao.model.Adocao
import com.ong.adocao.service.AdocaoService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/adocao"])
@Api(value = "API REST Adoção")
class AdocaoController {

    @Autowired
    lateinit var adocaoService: AdocaoService

    @PostMapping
    @ApiOperation(value = "Cadastra um animal")
    fun create(@RequestBody adocao: Adocao): ResponseEntity<Any> {
        this.adocaoService.create(adocao)
        return ResponseEntity(adocao, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Altera dados de um animal")
    fun update(@PathVariable id: Long, @RequestBody adocao: Adocao): ResponseEntity<Any> =
            ResponseEntity(this.adocaoService.update(id, adocao),HttpStatus.OK)

    @GetMapping
    @ApiOperation(value = "Mostra todos os animais")
    fun getAll(): ResponseEntity<Any> {
        var adocao = this.adocaoService.getAll()
        return ResponseEntity(adocao, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Mostra um único animal")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        var adocao = this.adocaoService.getById(id)
        return ResponseEntity(adocao, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta dados de um animal")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        adocaoService.delete(id)
        return ResponseEntity(Unit, HttpStatus.NO_CONTENT)
    }
}
