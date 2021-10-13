package com.ong.adocao.testService

import com.ong.adocao.model.Adocao
import com.ong.adocao.repository.AdocaoRepository
import com.ong.adocao.service.impl.AdocaoServiceImpl
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
import java.util.*


@SpringBootTest
@RunWith(MockitoJUnitRunner::class)
class AdocaoServiceTest {

    @InjectMocks
    lateinit var adocaoServiceImpl: AdocaoServiceImpl

    @Mock
    lateinit var adocaoRepository: AdocaoRepository

    lateinit var adocao: Adocao

    @Before
    fun setUp(){
        adocao = Adocao(1L,"raca","cor","sexo","porte",1,true)
    }
    @Test
    fun deveriaSalvarOCadastroDoAnimal(){
        `when`(adocaoRepository.save(adocao)).thenReturn(adocao)
        var result = adocaoServiceImpl.create(adocao)
        Assert.assertEquals("Deveria salvar o registro do animal",adocao,result)
    }
    @Test
    fun deveriaAtualizarOsDadosDoCadastroDoAnimal(){
        `when`(adocaoRepository.save((Adocao(1L,adocao.raca,adocao.cor,adocao.sexo,
            adocao.porte,1,true)))).thenReturn(adocao)
        var result = adocaoServiceImpl.update(1L,adocao)
        Assert.assertEquals("Deveria alterar os dados cadastrais do animal",result,Unit)
    }
    @Test
    fun deveriaBuscarTodosOdDadosCadastrados(){
        val adocaoList = listOf(adocao)
        `when`(adocaoRepository.findAll()).thenReturn(adocaoList)
        var result = adocaoServiceImpl.getAll()
        Assert.assertEquals("Deveria mostrar todos os animais já cadastrados",adocaoList,result)
    }
    @Test
    fun deveriaEncontrarIdDoRegistroDoAnimal(){
        var adocaoOptional = Optional.of(adocao)
        `when`(adocaoRepository.findById(1L)).thenReturn(adocaoOptional)
        var result = adocaoServiceImpl.getById(1L)
        Assert.assertEquals("Deveria mostrar apenas um animal do cadastro",adocao,result)
    }
    @Test
    fun deveriaDeletarORegistroDoAnimal(){
        doNothing().`when`(adocaoRepository).deleteById(1L)
        var result = adocaoServiceImpl.delete(1L)
        Assert.assertEquals("Deveria deletar o registro do animal cadastrado",result,Unit)
    }
}