package com.ong.adocao.testController

import com.ong.adocao.controller.AdocaoController
import com.ong.adocao.model.Adocao
import com.ong.adocao.service.AdocaoService
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doNothing
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

@SpringBootTest
@RunWith(MockitoJUnitRunner::class)
class AdocaoControllerTest {

    @InjectMocks
    lateinit var adocaoController: AdocaoController

    @Mock
    lateinit var adocaoService: AdocaoService

    lateinit var adocao: Adocao

    @Before
    fun setUp(){
        adocao = Adocao(1L,"raca","cor","sexo","porte",1,true)
    }
    @Test
    fun deveriaCriarCadastroDoAnimal(){
        `when`(adocaoService.create(adocao)).thenReturn(adocao)
        var result = adocaoController.create(adocao)
        Assert.assertEquals("Deveria criar o cadastro do animal",adocao,result.getBody())
    }
    @Test
    fun deveriaAtualizarOsDadosDoCadastroDoAnimal(){
        doNothing().`when`(adocaoService).update(1L,adocao)
        var result = adocaoController.update(1L,adocao)
        Assert.assertEquals("Deveria alterar os dados cadastrais do animal",
            HttpStatus.OK,result.statusCode)
    }
    @Test
    fun deveriaMostrarTodosOsAnimaisCadastrados(){
        val adocaoList = listOf(adocao)
        `when`(adocaoService.getAll()).thenReturn(adocaoList)
        var result = adocaoController.getAll()
        Assert.assertEquals("Deveria mostrar todos os animais já cadastrados", adocaoList,
        result.getBody())
    }
    @Test
    fun deveriaMostrarApenasUmAnimalDoCadastro(){
        `when`(adocaoService.getById(1L)).thenReturn(adocao)
        var result = adocaoController.getById(1L)
        Assert.assertEquals("Deveria mostrar apenas um animal do cadastro",adocao,result.getBody())
    }
    @Test
    fun deveriaDeletarORegistroDoAnimal(){
        doNothing().`when`(adocaoService).delete(1L)
        var result = adocaoController.delete(1L)
        Assert.assertEquals("Deveria deletar o registro do animal cadastrado",result.statusCode,
        HttpStatus.NO_CONTENT)
    }
}