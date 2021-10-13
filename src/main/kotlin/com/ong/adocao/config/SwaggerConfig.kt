package com.ong.adocao.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun api() =
            Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.ong.adocao.controller"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(metaDate())

    private fun metaDate() =
            ApiInfoBuilder()
                    .title("API ONG adoção de animais")
                    .description("Api para controle de cães na ong")
                    .version("1.0.0")
                    .termsOfServiceUrl("https://www.example.com/")
                    .license("Lincença: GPLv3")
                    .licenseUrl("https://www.gnu.org/licenses/gpl-3.0.html")
                    .contact(Contact("Yasmim Chyrlene", "https://github.com/yasmimchyrlene", "yasmimchyrlene@hotmail.com"))
                    .build()

}