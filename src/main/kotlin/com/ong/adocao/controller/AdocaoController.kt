package com.ong.adocao.controller

import com.ong.adocao.model.Adocao
import com.ong.adocao.service.AdocaoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/adocao"])
class AdocaoController {

    @Autowired
    lateinit var adocaoService: AdocaoService

    @PostMapping
    fun create(@RequestBody adocao: Adocao): ResponseEntity<Any> {
        this.adocaoService.create(adocao)
        return ResponseEntity(adocao, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody adocao: Adocao): ResponseEntity<Any> =
            ResponseEntity(this.adocaoService.update(id, adocao),HttpStatus.OK)

    @GetMapping
    fun getAll(): ResponseEntity<Any> {
        var adocao = this.adocaoService.getAll()
        return ResponseEntity(adocao, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        var adocao = this.adocaoService.getById(id)
        return ResponseEntity(adocao, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        adocaoService.delete(id)
        return ResponseEntity(Unit, HttpStatus.NO_CONTENT)
    }
}
